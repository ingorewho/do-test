package com.ignore.validator.impl;

import com.ignore.validator.Request;
import com.ignore.validator.Response;
import com.ignore.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-08-07
 **/
@Component
public class AgeValidator implements Validator<Request> {

    @Override
    public Response validate(Chain<Request> chain) {
        Request request = chain.getData();

        Response response = new Response();
        // 校验年龄逻辑

        // 执行下个校验器
        Response nextResponse = chain.proceed(request);
        response.addFailure(nextResponse);
        return response;
    }

}
