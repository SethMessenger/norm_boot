package com.seth.norm.cms.common.temp;

/**
 * @author  xunbo.xu
 * @desc    权限表临时替代
 * @date 18/12/18
 */
public enum PermissionEnum {

    /** 全开放 */
    PERMISSION_ALL(0, "ALL", "允许对任意数据进行编辑和修改");

    private Integer id;
    private String permistionName;
    private String description;

    private PermissionEnum() {
    }

    private PermissionEnum(Integer id, String permistionName, String description) {
        this.id = id;
        this.permistionName = permistionName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermistionName() {
        return permistionName;
    }

    public void setPermistionName(String permistionName) {
        this.permistionName = permistionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
