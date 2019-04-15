package com.seth.norm.cms.common.temp;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/12/19
 */
public enum RolePermissionRelEnum {

    ROLE_PERMISSION_REL_1(1, 1);

    private Integer roleId;
    private Integer permissionId;

    private RolePermissionRelEnum(){
    }

    RolePermissionRelEnum(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
