package com.ignore.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ignore.api.UserApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author renzhiqiang
 * @Description 用户服务controller
 * @Date 2019-03-16
 **/
@RestController
@RequestMapping(value = "/consumer")
public class UserController {
    @Reference(version = "1.0.0")
    private UserApiService userApiService;

    @PostMapping("/user/access")
    public String acess(@RequestBody String token){
        return userApiService.access(token);
    }
}
