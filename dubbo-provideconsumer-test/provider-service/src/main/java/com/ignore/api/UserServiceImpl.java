package com.ignore.api;


import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Author renzhiqiang
 * @Description 用户api接口实现类
 * @Date 2019-03-16
 **/
@Service(version = "1.0.0")
public class UserServiceImpl implements UserApiService{
    @Override
    public String access(String token) {

        return token;
    }
}
