package com.seth.norm.cms.service;

import com.seth.norm.cms.common.temp.PermissionEnum;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/12/18
 */
public interface PermissionService {

    /**
     * 通过userId获取用户所具有的权限
     * @param userId
     * @return List<Permission>
     * */
    List<PermissionEnum> findPermissionAndRoleNameByUserId(Integer userId);
}
