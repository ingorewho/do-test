package com.ignore.process;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 10:08 2019/1/29
 */
public class ClassProcess {
    public static final int NUM_1 = 1;
    public static int NUM_2 = 2;

    {
        System.out.println("执行非静态代码块.");
    }

    static {
        System.out.println("执行静态代码块.");
    }

    public ClassProcess(){
        System.out.println("执行构造器.");
    }

    public void test(){
        //修改打印信息，方便看到热部署的效果
        System.out.println("测试方法1.");
    }
}
