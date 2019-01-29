package com.ignore.config;

import java.io.*;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 10:15 2019/1/29
 */
public class DefinedClassLoader extends ClassLoader{
    /**class根路径.**/
    private String path;

    public DefinedClassLoader(String path){
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        //ClassLoader默认不执行链接操作，这里自定义执行链接操作
        return super.loadClass(className, true);
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] bytes = transfer(className);
        return super.defineClass(className, bytes, 0, bytes.length);
    }

    protected byte[] transfer(String className){
        InputStream input = null;
        ByteArrayOutputStream output = null;
        try{
            input = new FileInputStream(path + File.separator + className.replaceAll("[.]", "/") + ".class");
            output = new ByteArrayOutputStream();
            int i = 0;
            while ((i = input.read()) != -1){
                output.write(i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return output.toByteArray();
    }
}
