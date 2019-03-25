package com.ignore.jdk;

import java.util.function.Consumer;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-03-25
 **/
public class ConsumerTest {
    public static void test(){
        Consumer<String> consumer = a -> System.out.println(a.length());
        consumer.accept("12345");

        consumer.andThen(a-> System.out.println(a.charAt(1))).accept("555");
    }

    public static void main(String[] args){
        test();
    }
}
