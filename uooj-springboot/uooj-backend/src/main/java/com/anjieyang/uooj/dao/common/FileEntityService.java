package com.anjieyang.uooj.dao.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.common.File;
import com.anjieyang.uooj.pojo.vo.ACMContestRankVO;
import com.anjieyang.uooj.pojo.vo.OIContestRankVO;

import java.util.List;

public interface FileEntityService extends IService<File> {
    int updateFileToDeleteByUidAndType(String uid, String type);

    int updateFileToDeleteByGidAndType(Long gid, String type);

    List<File> queryDeleteAvatarList();

    List<File> queryCarouselFileList();

    List<List<String>> getContestRankExcelHead(List<String> contestProblemDisplayIDList, Boolean isACM);

    List<List<Object>> changeACMContestRankToExcelRowList(List<ACMContestRankVO> acmContestRankVOList,
                                                          List<String> contestProblemDisplayIDList,
                                                          String rankShowName);

    List<List<Object>> changOIContestRankToExcelRowList(List<OIContestRankVO> oiContestRankVOList,
                                                        List<String> contestProblemDisplayIDList,
                                                        String rankShowName);
}
