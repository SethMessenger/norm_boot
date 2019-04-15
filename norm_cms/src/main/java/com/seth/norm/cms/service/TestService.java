package com.seth.norm.cms.service;

import com.seth.norm.dao.model.Demo;

/**
 * @author  xunbo.xu
 * @desc    测试业务
 * @date 18/12/17
 */
public interface TestService {

    int addDemoMysql(Demo demo);

    Demo queryDemos(Integer id);

}
