# norm模板项目

#### 项目介绍
[springboot父子工程、聚合工程 模板工程构造](https://sethmessenger.github.io/)
[博客地址：Seth博客地址](https://sethmessenger.github.io/)  

#### norm 项目架构简述：
norm_template   父工程【父】：进行多个项目中的（用于统一依赖版本管理）   

***   
norm_cms    后台管理工程【子】：后台管理工程）   
norm_api    客户端API释放【子】：API   

***   
norm_service 项目基础业务组装(可复用业务)   
norm_component 第三方接口服务接入业务【子】   
norm_rpc    项目释放rpc连接管理【子】：项目的微服务实发和连接   
norm_dao    项目SQL连接管理【子】：项目的数据存储查询管理，缓存内容也置于此   
norm_utils  静态工具管理【子】：统一管理静态通用工具类   

***   
norm_docs   项目文档管理   

#### norm 项目框架设计简述：


#### 框架说明

[springboot创建父子工程、聚合工程及问题解决](http://blog.51cto.com/wyait/2137112) 
