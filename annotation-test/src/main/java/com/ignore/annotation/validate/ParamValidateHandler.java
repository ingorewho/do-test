package com.ignore.annotation.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author renzhiqiang
 * @Description 参数校验注解类
 * @Date 2019-06-21
 **/
public class ParamValidateHandler implements ConstraintValidator<ParamValidate, String> {

    @Override
    public void initialize(ParamValidate paramValidate) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // 这里可以做校验
        return false;
    }
}
