package com.ignore.jdk;

import java.util.function.Predicate;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-03-25
 **/
public class PredicateTest {
    public static void test(){
        Predicate<String> predicate = a -> a.equals("3");
        System.out.println(predicate.test("3"));
        System.out.println(predicate.and(a -> a.length() == 1).test("3"));
        System.out.println(predicate.or(a -> a.equals("2")).test("2"));
        System.out.println(predicate.negate().test("2"));
        System.out.println(Predicate.isEqual("2").test("2"));
    }

    public static void main(String[] args){
        test();
    }
}
