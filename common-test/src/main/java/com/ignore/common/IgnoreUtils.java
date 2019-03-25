package com.ignore.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * @Author renzhiqiang
 * @Description 忽略工具（忽略异常）
 * @Date 2019-03-20
 **/
public class IgnoreUtils {
    private static Logger logger = LogManager.getLogger();

    public static<T> T ignoreExeption(Callable<T> call){
        try {
            return call.call();
        }catch (Exception e){
            logger.error("发生异常.", e);
        }
        return null;
    }

    public <T, R> R ignoreException(Function<T, R> function, T t){
        try{
            return function.apply(t);
        }catch (Exception e){
            logger.error("发生异常.", e);
        }
        return null;
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("123");
        String a ="345";
        System.out.println(ignoreExeption(() -> {return list.get(0);}));

        IgnoreUtils ignoreUtils = new IgnoreUtils();
        System.out.println(ignoreUtils.ignoreException(item -> {return item+1;}, "1").toString());
        System.out.println(ignoreUtils.ignoreException(item -> {return item+1;}, 1).toString());
    }
}
