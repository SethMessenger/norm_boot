package com.seth.norm.cms.service;

import com.seth.norm.cms.common.temp.UserEnum;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/12/18
 */
public interface UserService {
    /**
     * 通过userName获取用户信息
     * @param username
     * @return User
     * */
    UserEnum findByUsername(String username);

    /**
     * 检查用户登录权限<br/>
     * 将当前用户的权限进行设置，保证cms系统内的权限系统生效
     * @param userName
     * @param password
     * @return
     */
    boolean checkLogin(String userName, String password);

}
