package com.ignore.validator.impl;

import com.ignore.utils.SpringIocUtil;
import com.ignore.validator.Request;
import com.ignore.validator.Response;
import com.ignore.validator.Validator;

import java.util.List;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-08-08
 **/
public final class ValidateChain implements Validator.Chain<Request> {
    private final Request request;
    private List<String> interceptors;
    private final int index;

    /**
     * 构造器
     * @param request
     * @param interceptors
     * @param index
     */
    public ValidateChain(Request request, List<String> interceptors, int index) {
        this.request = request;
        this.interceptors = interceptors;
        this.index = index;
    }

    @Override
    public Request getData() {
        return this.request;
    }

    @Override
    public Response proceed(Request request) {
        if (index >= interceptors.size()) {
            return null;
        }

        ValidateChain next = new ValidateChain(request, interceptors, index + 1);
        String interceptorName = interceptors.get(index);
        Validator validator = SpringIocUtil.getBean(interceptorName, Validator.class);
        Response response = validator.validate(next);
        return response;
    }
}
