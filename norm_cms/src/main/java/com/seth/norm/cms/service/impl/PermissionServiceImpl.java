package com.seth.norm.cms.service.impl;


import com.seth.norm.cms.common.temp.PermissionEnum;
import com.seth.norm.cms.common.temp.RolePermissionRelEnum;
import com.seth.norm.cms.common.temp.UserRoleRelEnum;
import com.seth.norm.cms.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/12/18
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    /**
     * 通过userId获取用户所具有的权限
     *
     * @param userId
     * @return List<Permission>
     */
    @Override
    public List<PermissionEnum> findPermissionAndRoleNameByUserId(Integer userId) {
        List<PermissionEnum> permissions = new ArrayList<PermissionEnum>();
        for (UserRoleRelEnum userRoleRel : UserRoleRelEnum.values()){
            Integer roleId = userRoleRel.getRoleId();
            for (RolePermissionRelEnum rolePermissionRel : RolePermissionRelEnum.values()){
                if(rolePermissionRel.getRoleId().equals(roleId)){
                    for (PermissionEnum permission : PermissionEnum.values()){
                        if(permission.getId().equals(rolePermissionRel.getPermissionId())){
                            permissions.add(permission);
                        }
                    }
                }
            }
        }
        return permissions;
    }
}
