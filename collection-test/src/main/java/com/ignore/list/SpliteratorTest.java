package com.ignore.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * @Author renzhiqiang
 * @Description 可拆分迭代器使用
 * @Date 2019-03-29
 **/
public class SpliteratorTest {

    public static void test(){
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("2");
        dataList.add("3");
        dataList.add("4");
        dataList.add("5");

        Spliterator<String> spliterator = dataList.spliterator();
        spliterator.tryAdvance(item -> System.out.println(item));
        System.out.println("预估剩余元素："  + spliterator.estimateSize());



        Spliterator<String> newSpliterator = spliterator.trySplit();
        System.out.println("新迭代器中预估元素：" + newSpliterator.estimateSize());
        System.out.println("旧迭代器中预估元素：" + spliterator.estimateSize());
        newSpliterator.forEachRemaining(item -> System.out.println(item));

        spliterator.forEachRemaining(item -> System.out.println(item));
        System.out.println("旧迭代器预估元素：" + spliterator.estimateSize());
    }


    public static void main(String[] args){
        test();
    }
}
