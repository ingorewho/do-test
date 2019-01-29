package com.ignore.process;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 10:12 2019/1/29
 */
public class Main {
    public static void main(String[] args)
    {
        //放开注释每个单独执行，debug到ClassLoader.loadClass方法，查看是否执行加载，同时查看运行结果
//        test_1();
        test_2();
//        test_3();
//        test_4();
    }

    /**
     * 测试调用常量是否会引起类加载
     */
    private static void test_1(){
        //1.调用常量
        System.out.println("调用常量");
        int num1 = ClassProcess.NUM_1;
    }

    private static void test_2(){
        //2.调用静态变量
        System.out.println("调用静态变量");
        int num2 = ClassProcess.NUM_2;
    }

    private static void test_3(){
        //3.调用class.forName方法
        System.out.println("调用class.forName");
        try {
            Class.forName("com.ignore.process.ClassProcess");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test_4(){
        //4.调用构造器
        System.out.println("调用构造器实例化");
        ClassProcess process = new ClassProcess();
    }
}
