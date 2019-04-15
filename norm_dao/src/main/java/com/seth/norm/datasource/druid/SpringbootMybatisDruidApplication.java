package com.seth.norm.datasource.druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author  xunbo.xu
 * @desc    入口
 * @date 18/12/17
 */
//@SpringBootApplication
//@ServletComponentScan
//@ImportResource(locations = { "classpath:druid-bean.xml" })
public class SpringbootMybatisDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisDruidApplication.class, args);
    }
}