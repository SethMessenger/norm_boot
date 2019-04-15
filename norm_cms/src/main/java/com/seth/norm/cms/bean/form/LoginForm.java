package com.seth.norm.cms.bean.form;

/**
 * @author  xunbo.xu
 * @desc    cms登录表单
 * @date 18/12/22
 */
public class LoginForm {

    /** 用户登录名 */
    private String userName;
    /** 用户登录密码 */
    private String password;
    /** 用户登录时间戳 TODO 用户升级进行前后端密匙校验 */
    private String timestamp;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
