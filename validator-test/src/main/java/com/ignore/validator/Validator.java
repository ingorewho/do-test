package com.ignore.validator;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-08-07
 **/
public interface Validator<T> {
    Response validate(Chain<T> chain);


    interface Chain<T> {
        T getData();

        Response proceed(T data);
    }
}
