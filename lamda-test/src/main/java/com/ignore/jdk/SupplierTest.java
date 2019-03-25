package com.ignore.jdk;

import java.util.function.Supplier;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-03-25
 **/
public class SupplierTest {
    public static void test(){
        String str = "123";
        Supplier<String> supplier = ()->{return str.intern();};
        System.out.println(supplier.get());
    }

    public static void main(String[] args){
        test();
    }
}
