package com.anjieyang.uooj.dao.problem;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.anjieyang.uooj.pojo.dto.ProblemDTO;
import com.anjieyang.uooj.pojo.vo.ImportProblemVO;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.anjieyang.uooj.pojo.entity.problem.Problem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */

public interface ProblemEntityService extends IService<Problem> {
    Page<ProblemVO> getProblemList(int limit, int currentPage, Long pid, String title,
                                   Integer difficulty, List<Long> tid, String oj);

    boolean adminUpdateProblem(ProblemDTO problemDto);

    boolean adminAddProblem(ProblemDTO problemDto);

    ImportProblemVO buildExportProblem(Long pid, List<HashMap<String, Object>> problemCaseList, HashMap<Long, String> languageMap, HashMap<Long, String> tagMap);
}
