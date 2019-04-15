package com.seth.norm.cms.service.impl;

import com.seth.norm.cms.common.temp.UserEnum;
import com.seth.norm.cms.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/12/18
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public UserEnum findByUsername(String username){
        for (UserEnum user : UserEnum.values()){
            if(user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        for (UserEnum user : UserEnum.values()){
            if(userName.equals(user.getUserName()) && password.equals(user.getUserPwd())){
                return true;
            }
        }
        return false;
    }

}
