package com.ignore;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author renzhiqiang
 * @Description 生产者启动类
 * @Date 2019-03-16
 **/
@SpringBootApplication
@EnableDubboConfiguration
public class ProviderApplication {
    public static void main(String[] args){
        SpringApplication.run(ProviderApplication.class, args);
    }
}