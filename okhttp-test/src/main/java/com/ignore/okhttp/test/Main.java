package com.ignore.okhttp.test;

import com.ignore.okhttp.entity.Header;
import com.ignore.okhttp.process.ProcessOkhttp;
import okhttp3.*;
import okio.BufferedSink;

import java.io.File;
import java.io.IOException;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 14:48 2019/1/31
 */
public class Main {
    public static void main(String[] args) {
        //1.重复执行get同步请求，为了方便查看缓存命中信息
        System.out.println(ProcessOkhttp.get("https://api.apiopen.top/searchAuthors?name=%E6%9D%8E%E7%99%BD", null));
        System.out.println(ProcessOkhttp.get("https://api.apiopen.top/searchAuthors?name=%E6%9D%8E%E7%99%BD", null));

        //2.执行get异步请求
        ProcessOkhttp.getAsync("https://api.apiopen.top/searchAuthors?name=%E6%9D%8E%E7%99%BD", null);
        //3.执行post同步请求：提交form表单
        RequestBody requestBody = new FormBody.Builder()
                .add("city", "成都")
                .build();
        System.out.println(ProcessOkhttp.post("https://www.apiopen.top/weatherApi", null, requestBody));
        //4.执行post异步请求：提交文件
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        File file = new File("D:/test.txt");
        requestBody = RequestBody.create(mediaType, file);
        ProcessOkhttp.postAsync("https://api.github.com/markdown/raw", null, requestBody);
        //5.执行post异步请求：提交流
        requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MediaType.parse("text/x-markdown; charset=utf-8");
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8("hello world");
            }
        };
        ProcessOkhttp.postAsync("https://api.github.com/markdown/raw", null, requestBody);
        //6.执行post异步请求：提交分块请求
        requestBody = new MultipartBody.Builder()
                //第一块请求实体
                .addPart(Headers.of("Content-Disposition", "form-data; name=\"title\""),
                        RequestBody.create(null, "log"))
                //第二块请求实体
                .addPart(Headers.of("Content-Disposition", "form-data; name=\"img\""),
                        RequestBody.create(MediaType.parse("img/png"), new File("D:/test.png")))
                .build();
        ProcessOkhttp.postAsync("https://api.github.com/markdown/raw", null, requestBody);
    }
}
