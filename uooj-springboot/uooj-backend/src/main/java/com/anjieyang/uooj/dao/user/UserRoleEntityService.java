package com.anjieyang.uooj.dao.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.pojo.entity.user.Role;
import com.anjieyang.uooj.pojo.entity.user.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.vo.UserRolesVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
public interface UserRoleEntityService extends IService<UserRole> {

    UserRolesVO getUserRoles(String uid, String username);

    List<Role> getRolesByUid(String uid);

    IPage<UserRolesVO> getUserList(int limit, int currentPage, String keyword, Boolean onlyAdmin);

    void deleteCache(String uid, boolean isRemoveSession);

    String getAuthChangeContent(int oldType,int newType);
}
