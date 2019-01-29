package com.ignore.config;

import java.lang.reflect.Method;

/**
 * @Author: ignore1992
 * @Description: 类加载器常见的用途有类的隔离和热替换
 * @Date: Created In 11:23 2019/1/29
 */
public class Main {
    public static void main(String[] args)
    {
        try {
            String path = "/D:/work/project/workspace_git/do-test/classloader-test/target/classes";
            DefinedClassLoader classLoader = new DefinedClassLoader(Thread.currentThread().getContextClassLoader(),path);
            //调用loadClass方法，会通过双亲委派模式，最终使用AppClassLoader来加载类
            Class clazz1 = classLoader.loadClass("com.ignore.process.ClassProcess");
            System.out.println(clazz1.getClassLoader());
            int i = 0;
            while (i <= 10){
                //每次重新new ClassLoader，这里不设置父类加载器，避免使用双亲委派，从而简单实现热部署功能
                classLoader = new DefinedClassLoader(null, path);
                //直接调用自定义类加载器的findClass来加载类
                Class clazz2 = classLoader.findClass("com.ignore.process.ClassProcess");
                System.out.println(clazz2.getClassLoader());
                Object obj = clazz2.newInstance();
                Method method = clazz2.getMethod("test");
                method.invoke(obj);
                //休息5秒，这时要去修改ClassProcess类的test方法，方便测试热部署
                Thread.sleep(5 * 1000L);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
