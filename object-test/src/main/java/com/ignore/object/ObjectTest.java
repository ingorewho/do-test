package com.ignore.object;

/**
 * @Author renzhiqiang
 * @Description Object类的一些测试
 * @Date 2019-04-23
 **/
public class ObjectTest implements Cloneable{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ObjectTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void cloneTest(){

        ObjectTest test = new ObjectTest();
        test.setAge(27);
        test.setName("ignore");
        ObjectTest clone = null;
        try {
            clone =(ObjectTest)test.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        System.out.println("equals:" + (test.equals(clone)));
        System.out.println("==:" + (test== clone));

        System.out.println("基本属性" + clone);
    }


    public static void main(String[] args){
        ObjectTest.cloneTest();
    }


}
