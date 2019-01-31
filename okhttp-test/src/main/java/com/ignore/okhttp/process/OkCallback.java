package com.ignore.okhttp.process;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 14:09 2019/1/31
 */
public class OkCallback implements Callback {
    @Override
    public void onFailure(Call call , IOException e) {
        System.err.println(e);
    }

    @Override
    public void onResponse(Call call , Response response) throws IOException {
        System.out.println("请求成功，返回结果:" + response.body().string());
    }
}
