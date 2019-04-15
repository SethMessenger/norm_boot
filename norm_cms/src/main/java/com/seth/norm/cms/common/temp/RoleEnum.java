package com.seth.norm.cms.common.temp;

/**
 * @author  xunbo.xu
 * @desc    角色表临时替代
 * @date 18/12/18
 */
public enum RoleEnum {

    /** 开发者 */
    ROLE_SETH(0, "开发者权限", "允许对任意数据进行编辑和修改"),
    /** 管理员 */
    ROLE_ROOT(1, "管理员权限", "对于基本的系统开放信息进行管理，兼管权限分发");

    private Integer id;
    private String roleName;
    private String description;

    private RoleEnum() {
    }

    private RoleEnum(Integer id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
