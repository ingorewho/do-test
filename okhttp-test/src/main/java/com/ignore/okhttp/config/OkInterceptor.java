package com.ignore.okhttp.config;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @Author: ignore1992
 * @Description: 全局拦截器
 * @Date: Created In 16:10 2019/1/31
 */
public class OkInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        Response response = chain.proceed(request);
        long endTime = System.currentTimeMillis();
        System.out.println("请求耗时: " + (endTime - startTime) + "ms");
        return response;
    }
}
