package com.ignore.okhttp.process;

import com.ignore.okhttp.config.OkhttpConfig;
import com.ignore.okhttp.entity.Header;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 18:05 2019/1/30
 */
public class ProcessOkhttp {

    /**
     * 同步执行get请求
     * @param url
     * @return
     */
    public static String get(String url, Header header){
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        if (header != null) {
            builder.addHeader(header.getName(), header.getValue());
        }
        Call call = OkhttpConfig.client().newCall(builder.build());
        try {
            Response response = call.execute();
            return response.body().string();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步执行get请求
     * @param url
     */
    public static void getAsync(String url, Header header){
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        if (header != null) {
            builder.addHeader(header.getName(), header.getValue());
        }
        Call call = OkhttpConfig.client().newCall(builder.build());
        //提交异步请求，回调函数来处理结果
        call.enqueue(new OkCallback());
    }

    public static String post(String url, Header header, RequestBody requestBody){
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);
        if (header != null) {
            builder.addHeader(header.getName(), header.getValue());
        }
        Call call = OkhttpConfig.client().newCall(builder.build());
        try {
            Response response = call.execute();
            return response.body().string();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步执行post
     * @param url
     * @param requestBody
     */
    public static void postAsync(String url, Header header,RequestBody requestBody){
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);
        if (header != null) {
            builder.addHeader(header.getName(), header.getValue());
        }
        Call call = OkhttpConfig.client().newCall(builder.build());
        call.enqueue(new OkCallback());
    }
}
