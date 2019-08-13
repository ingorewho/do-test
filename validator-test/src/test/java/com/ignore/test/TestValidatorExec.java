package com.ignore.test;

import com.ignore.validator.Request;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-08-13
 **/
@SpringBootTest
public class TestValidatorExec {
    @Autowired
    private TestValidator testValidator;

    @Test
    public void validate() {
        Request request = Request.newBuilder().name("test").age(26).build();
        testValidator.process(request);
    }
}
