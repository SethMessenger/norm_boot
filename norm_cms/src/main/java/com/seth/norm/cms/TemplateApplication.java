package com.seth.norm.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * springboot启动目录，程序入口<br/>
 * mybatis扫描mapper目录
 */
@SpringBootApplication
@MapperScan("com.seth.norm.dao.mapper")
@ServletComponentScan(basePackages = {"com.seth.norm"})
@ImportResource(locations = { "classpath:druid-bean.xml" })
public class TemplateApplication {
	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}
}
