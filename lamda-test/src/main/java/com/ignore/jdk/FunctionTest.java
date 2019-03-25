package com.ignore.jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-03-25
 **/
public class FunctionTest {
    public static void test(){
        Function<Object, Boolean> function = a -> a.equals("2");
        System.out.println(function.apply("2"));
        Function<String, String> before = a -> a.intern();
        System.out.println((function.compose(before)).apply("2"));
        Function<Boolean, Boolean> function1 = a-> a.booleanValue() == true;
        System.out.println(function.andThen(function1).apply("2"));
        List<String> list = new ArrayList<>();
        list.add("123");
        System.out.println(list.stream().map(Function.identity()).collect(Collectors.toList()));
    }

    public static void main(String[] args){
        test();
    }

}

