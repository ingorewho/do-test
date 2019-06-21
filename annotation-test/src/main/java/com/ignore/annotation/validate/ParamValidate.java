package com.ignore.annotation.validate;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * @Author renzhiqiang
 * @Description 参数校验注解
 * @Date 2019-06-21
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = ParamValidateHandler.class)
public @interface ParamValidate {

}
