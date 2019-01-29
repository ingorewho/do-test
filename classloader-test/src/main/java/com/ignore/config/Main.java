package com.ignore.config;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:23 2019/1/29
 */
public class Main {
    public static void main(String[] args)
    {
        DefinedClassLoader classLoader = new DefinedClassLoader("/D:/work/project/workspace_git/do-test/classloader-test/target/classes");
        try {
            //调用loadClass方法，会通过双亲委派模式，最终使用AppClassLoader来加载类
            Class clazz1 = classLoader.loadClass("com.ignore.process.ClassProcess");
            System.out.println(clazz1.getClassLoader());
            //直接调用自定义类加载器的findClass来加载类
            Class clazz2 = classLoader.findClass("com.ignore.process.ClassProcess");
            System.out.println(clazz2.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
