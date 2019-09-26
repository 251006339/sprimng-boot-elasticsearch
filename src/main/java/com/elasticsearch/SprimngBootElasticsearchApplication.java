package com.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//springboot elasticsearch 2.1.9 版本   2.1.9   2---2  3---5
//需要和elastic服务端对应  2.3.5        "2.4.0",
@SpringBootApplication
public class SprimngBootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprimngBootElasticsearchApplication.class, args);
    }

}
/*
  数据库    index
  表名       type<对象名>
  文档       对象
  属性       属性


head - --返回响应码  200  400


 */