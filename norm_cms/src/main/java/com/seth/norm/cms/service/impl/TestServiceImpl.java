package com.seth.norm.cms.service.impl;

import com.seth.norm.dao.mapper.DemoMapper;
import com.seth.norm.cms.service.TestService;
import com.seth.norm.dao.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/12/17
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public int addDemoMysql(Demo demo) {
        return this.demoMapper.insert(demo);
    }

    @Override
    public Demo queryDemos(Integer id) {
        return this.demoMapper.selectByPrimaryKey(id);
    }
}
