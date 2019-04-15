package com.seth.norm.cms.controller;

import com.seth.norm.cms.bean.common.BaseView;
import com.seth.norm.cms.bean.common.MessageView;
import com.seth.norm.cms.bean.form.LoginForm;
import com.seth.norm.cms.common.ErrorCodeEnum;
import com.seth.norm.cms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author  xunbo.xu
 * @desc    用户登录和权限管理controller
 * @date 18/12/22
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param form
     * @return
     */
    @RequestMapping(value="/login.json",method= RequestMethod.GET)
    @ResponseBody
    public BaseView login(LoginForm form){
        if(null == form || StringUtils.isEmpty(form.getUserName())  || StringUtils.isEmpty(form.getPassword())){
            return BaseView.PARAM_ERROR;
        }
        if(this.userService.checkLogin(form.getUserName(), form.getPassword())){
            return new MessageView(ErrorCodeEnum.SUCCESS, "欢迎进入norm系统");
        }
        return new MessageView(ErrorCodeEnum.PARAM_ERROR, "用户不存在，请检查您的登录信息");
    }

    public BaseView updateUserInfo(){
        return BaseView.FAIL;
    }

    /** 用户登出 */
    public BaseView userExit(){
        return BaseView.FAIL;
    }

}
