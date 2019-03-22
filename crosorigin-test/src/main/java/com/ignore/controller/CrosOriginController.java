package com.ignore.controller;

import com.ignore.service.CrosOriginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author renzhiqiang
 * @Description 测试@Crosorigin注解
 * @Date 2019-03-22
 **/
@RestController
public class CrosOriginController {
    @Resource
    private CrosOriginService crosOriginServiceImpl;

    @PostMapping(value = "/cross")
//    @CrossOrigin(origins = {"http://localhost:8099"})
    public String test(@RequestBody String data){
        crosOriginServiceImpl.cross();
        System.out.println(data);
        return "index";
    }
}
