package com.ignore.jkdspec;

/**
 * @Author renzhiqiang
 * @Description final测试
 * @Date 2019-04-26
 **/
public class FinalTest {
    public static void main(String[] args){
        FinalObject object = new FinalObject("123", 12);

    }
}

/**
 * 一但赋值，不能修改属性引用
 */
final class FinalObject{
    final String name;
    final int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    FinalObject(String name, int age){
        this.age = age;
        this.name = name;
    }
}
