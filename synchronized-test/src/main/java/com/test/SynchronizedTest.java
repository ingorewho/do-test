package com.test;

import com.test.lock.LockObject;

/**
 * @Author: ingore1992
 * @Description: 验证多线程下 线程竞争锁时间较长，锁会升级到重量级锁，锁竞争结束一段时间后，锁降级。
 * @Date: Created In 15:44 2019/1/22
 */
public class SynchronizedTest {

    public static void main(String[] args)throws Exception{
        LockObject entity = new LockObject();
        Thread t1 = new Thread(()->{
            synchronized (entity){
                System.out.println("线程1获取到锁");
                try {
                    //持有锁几分钟
                    Thread.sleep(60000 * 2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1获释放锁");
            }
        });

        Thread t2 = new Thread(()->
        {
            synchronized (entity){
                System.out.println("线程2获取到锁");
                try {
                    Thread.sleep(60000 * 2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2释放锁");
            }
        });
        t1.start();
        t2.start();

        System.out.println("主线程多休息一会，方便等待锁降级.");
        Thread.sleep(60000 * 100L);
    }
}
