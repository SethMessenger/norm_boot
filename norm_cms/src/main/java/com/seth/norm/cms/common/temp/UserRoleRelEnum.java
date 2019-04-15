package com.seth.norm.cms.common.temp;

/**
 * @author  xunbo.xu
 * @desc    用户角色关联中间临时表
 * @date 18/12/19
 */
public enum  UserRoleRelEnum {

    USER_ROLE_REL_1(1, 1);

    private Integer roleId;
    private Integer userId;

    UserRoleRelEnum(){
    }

    UserRoleRelEnum(Integer roleId, Integer userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
