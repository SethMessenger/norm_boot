package com.seth.norm.cms.controller;

import com.seth.norm.cms.bean.common.BaseView;
import com.seth.norm.cms.bean.DeployView;
import com.seth.norm.cms.bean.common.MessageView;
import com.seth.norm.cms.bean.common.ObjectView;
import com.seth.norm.cms.common.ErrorCodeEnum;
import com.seth.norm.cms.service.TestService;
import com.seth.norm.dao.model.Demo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

/**
 * @author  xunbo.xu
 * @desc    项目测试目录,用于项目的启动测试 & 各项测试
 * @date 18/9/17
 */
@Controller
public class TestController {


    /** 部署版本 TODO 使用MySQL或者其他线上服务进行管理 */
    private static String version = "0.0.1";
    /** 最近部署时间 */
    private static Date lastDate = new Date();

    @Autowired
    private TestService testService;


    /**
     * 项目启动测试
     */
    @RequestMapping(value = "ping", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public BaseView ping(){
        BaseView result = BaseView.FAIL;
        try {
            if(null != lastDate && StringUtils.isNotEmpty(version)){
                result = new DeployView(version, lastDate);
            }
        } catch (Exception e){
            result = BaseView.FAIL;
        }
        return result;
    }


    /**
     * 测试freemarker跳转路径
     * @param path
     * @return
     */
    @RequestMapping("freemarker")
    public String toFtl(String path){
        return "cms/" + path;
    }

    /**
     * 检测当前MySQL连接
     * @return
     */
    @RequestMapping(value = "testMysql", method = { RequestMethod.GET })
    @ResponseBody
    public BaseView testMysql(){
        Demo demo = new Demo(1, "SethNick", "openid_wechat", "unionid_wechat", "17600812617", "sethWechat", "http://www.baidu.com");
        int result = this.testService.addDemoMysql(demo);
        if(result > 0){
            Demo demoResult = this.testService.queryDemos(1);
            return new ObjectView<Demo>(demoResult);
        }
        return new MessageView(ErrorCodeEnum.FAIL,"插入失败");
    }


}
