package com.anjieyang.uooj.remoteJudge.task.Impl;


import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.anjieyang.uooj.remoteJudge.entity.RemoteJudgeDTO;
import com.anjieyang.uooj.remoteJudge.entity.RemoteJudgeRes;
import org.springframework.util.StringUtils;
import com.anjieyang.uooj.util.Constants;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public class GYMJudge extends CodeForcesJudge {

    private final static String JUDGE_PROTOCOL = "/data/judgeProtocol";

    @Override
    protected String getSubmitUrl(String contestNum) {
        return IMAGE_HOST + "/gym/" + contestNum + "/submit";
    }

    @Override
    protected String getRunIdUrl() {
        RemoteJudgeDTO remoteJudgeDTO = getRemoteJudgeDTO();
        return IMAGE_HOST + String.format("/gym/%s/my", remoteJudgeDTO.getContestId());
    }

    public static void main(String[] args) {
        String S = HttpUtil.get(HOST + "/submissions/zhanshihui");

        String regex = "<span .*? submissionId=\"170036627\" submissionVerdict=\"(.*?)\" .*?>.*?</span>.*?<i .*?></i>[\\s]*?</td>[\\s]*?" +
                "<td class=\"time.*?\">[\\s]*?(\\d+)&nbsp;ms[\\s]*?</td>[\\s]*?" +
                "<td class=\"memory.*?\">[\\s]*?(\\d+)&nbsp;KB[\\s]*?</td>[\\s]*?</tr>";
        Pattern pattern = PatternPool.get(regex, Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(S);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }

    @Override
    public RemoteJudgeRes result() {
        return getNotTestCaseDetailResult();
    }

    private RemoteJudgeRes getNotTestCaseDetailResult() {
        HttpRequest.getCookieManager().getCookieStore().removeAll();

        RemoteJudgeDTO remoteJudgeDTO = getRemoteJudgeDTO();
        Long submitId = remoteJudgeDTO.getSubmitId();

        RemoteJudgeRes remoteJudgeRes = RemoteJudgeRes.builder()
                .status(Constants.Judge.STATUS_JUDGING.getStatus())
                .build();

        if (remoteJudgeDTO.getCookies() == null) {
            login();
        }
        String url = getRunIdUrl();
        HttpRequest homeRequest = HttpUtil.createGet(url);
        homeRequest.cookie(remoteJudgeDTO.getCookies());
        HttpResponse homeResponse = homeRequest.execute();

        String regex = "<span .*? submissionId=\"" + submitId + "\" submissionVerdict=\"(.*?)\" .*?>.*?</span>.*?<i .*?></i>[\\s]*?</td>[\\s]*?" +
                "<td class=\"time.*?\">[\\s]*?(\\d+)&nbsp;ms[\\s]*?</td>[\\s]*?" +
                "<td class=\"memory.*?\">[\\s]*?(\\d+)&nbsp;KB[\\s]*?</td>[\\s]*?</tr>";
        Pattern pattern = PatternPool.get(regex, Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(homeResponse.body());

        if (matcher.find()) {
            String csrfToken = ReUtil.get("data-csrf='(\\w+)'", homeResponse.body(), 1);
            String statusStr = matcher.group(1);
            Constants.Judge statusType = statusMap.get(statusStr);
            if (statusType == Constants.Judge.STATUS_JUDGING) {
                return remoteJudgeRes;
            }
            String timeStr = matcher.group(2); // ms
            if (StringUtils.isEmpty(timeStr)) {
                remoteJudgeRes.setTime(0);
            } else {
                remoteJudgeRes.setTime(Integer.parseInt(timeStr));
            }
            String memoryStr = matcher.group(3); // KB
            if (StringUtils.isEmpty(memoryStr)) {
                remoteJudgeRes.setMemory(0);
            } else {
                remoteJudgeRes.setMemory(Integer.parseInt(memoryStr));
            }
            remoteJudgeRes.setStatus(statusType.getStatus());
            if (statusType == Constants.Judge.STATUS_COMPILE_ERROR) {
                HttpRequest CEINFORequest = HttpUtil.createPost(HOST + JUDGE_PROTOCOL)
                        .cookie(remoteJudgeDTO.getCookies())
                        .timeout(30000);
                CEINFORequest.form(MapUtil
                        .builder(new HashMap<String, Object>())
                        .put("csrf_token", csrfToken)
                        .put("submissionId", remoteJudgeDTO.getSubmitId()).map());

                HttpResponse CEINFOResp = CEINFORequest.execute();
                String CEInfo = UnicodeUtil.toString(CEINFOResp.body()).replaceAll("(\\\\r)?\\\\n", "\n")
                        .replaceAll("\\\\\\\\", "\\\\");
                remoteJudgeRes.setErrorInfo(CEInfo);
            }
        }
        return remoteJudgeRes;
    }

}