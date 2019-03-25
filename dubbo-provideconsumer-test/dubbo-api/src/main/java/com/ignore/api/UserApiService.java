package com.ignore.api;

/**
 * @Author renzhiqiang
 * @Description 公共api接口
 * @Date 2019-03-16
 **/
public interface UserApiService {
    /**
     * 用户接入
     * @param token
     * @return
     */
    String access(String token);
}
