package com.ignore.annotation.aspect;

import java.lang.annotation.*;

/**
 * @Author renzhiqiang
 * @Description 日志记录注解
 * @Date 2019-06-21
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LogRecord {
    String desc() default "日志记录";
}
