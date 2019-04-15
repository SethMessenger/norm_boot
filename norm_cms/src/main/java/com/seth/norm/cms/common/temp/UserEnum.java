package com.seth.norm.cms.common.temp;

/**
 * @author  xunbo.xu
 * @desc    用户表临时替代
 * @date 18/12/18
 */
public enum UserEnum {

    /** 超级权限用户 */
    USER_SETH(0, "SethMessenger", "sethAPI123", "SethMessenger", "17600812617", "00002617"),
    /** 管理员用户 */
    USER_ROOT(1, "user_root", "", "root", "15275539525", "00000001"),
    /** 可读用户 */
    USER_READ(2, "user_read", "", "read", "17600812617", "00000002"),
    /** 可写用户 */
    USER_WRITE(3, "user_write", "", "write", "13953877895", "00000003");

    private Integer id;
    private String userName;
    private String userPwd;
    private String nickName;
    private String mobile;
    private String cardNo;

    private UserEnum() {
    }

    private UserEnum(Integer id, String userName, String userPwd, String nickName, String mobile, String cardNo) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.nickName = nickName;
        this.mobile = mobile;
        this.cardNo = cardNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public String toString() {
        return "UserEnum{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", cardNo='" + cardNo + '\'' +
                '}';
    }
}
