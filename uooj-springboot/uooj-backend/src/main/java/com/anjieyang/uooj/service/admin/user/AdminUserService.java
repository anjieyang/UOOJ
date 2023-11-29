package com.anjieyang.uooj.service.admin.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.AdminEditUserDTO;
import com.anjieyang.uooj.pojo.vo.UserRolesVO;

import java.util.List;
import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface AdminUserService {

    public CommonResult<IPage<UserRolesVO>> getUserList(Integer limit, Integer currentPage, Boolean onlyAdmin, String keyword);

    public CommonResult<Void> editUser(AdminEditUserDTO adminEditUserDto);

    public CommonResult<Void> deleteUser(List<String> deleteUserIdList);

    public CommonResult<Void> insertBatchUser(List<List<String>> users);

    public CommonResult<Map<Object,Object>> generateUser(Map<String, Object> params);

}