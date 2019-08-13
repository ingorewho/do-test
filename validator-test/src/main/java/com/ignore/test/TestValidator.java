package com.ignore.test;

import com.ignore.validator.Request;
import com.ignore.validator.Validator;
import com.ignore.validator.impl.ValidateChain;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-08-13
 **/
@Component
public class TestValidator implements InitializingBean {
    private List<String> validators;

    @Override
    public void afterPropertiesSet() throws Exception {
        validators = new ArrayList<>();
        validators.add("nameValidator");
        validators.add("ageValidator");
    }

    public void process(Request request) {

        Validator.Chain<Request> chain = new ValidateChain(request, validators, 0);
        chain.proceed(request);
    }
}
