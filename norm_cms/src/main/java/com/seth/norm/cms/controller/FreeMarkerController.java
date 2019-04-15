package com.seth.norm.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author  xunbo.xu
 * @desc    进行freemarker跳转管理的controller
 * @date 18/12/22
 */
@Controller
public class FreeMarkerController {

    @RequestMapping(value="/freemarker/{pagePath}",method= RequestMethod.GET)
    @ResponseBody
    public String login(@PathVariable String pagePath){
        System.out.println("here");
        return pagePath;
    }

}
