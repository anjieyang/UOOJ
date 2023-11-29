package com.anjieyang.uooj.crawler.language;

import com.anjieyang.uooj.pojo.entity.problem.Language;
import com.anjieyang.uooj.utils.Constants;

;import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public class LanguageContext {

    private LanguageStrategy languageStrategy;

    public LanguageContext(LanguageStrategy languageStrategy) {
        this.languageStrategy = languageStrategy;
    }

    public LanguageContext(Constants.RemoteOJ remoteOJ) {
        switch (remoteOJ) {
            case SPOJ:
                languageStrategy = new SPOJLanguageStrategy();
                break;
            case ATCODER:
                languageStrategy = new AtCoderLanguageStrategy();
                break;
            default:
                throw new RuntimeException("未知的OJ的名字，暂时不支持！");
        }
    }

    public List<Language> buildLanguageList(){
        return languageStrategy.buildLanguageList();
    }

    public String getLanguageNameById(String id) {
        return languageStrategy.getLanguageNameById(id);
    }

    public List<Language> buildLanguageListByIds(List<Language> allLanguageList, List<String> langIdList) {
        return languageStrategy.buildLanguageListByIds(allLanguageList, langIdList);
    }
}