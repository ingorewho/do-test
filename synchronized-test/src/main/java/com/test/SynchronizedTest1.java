package com.test;

import com.test.lock.LockObject;

/**
 * @Author: ingore1992
 * @Description: 验证单线程下 synchronized获取到锁后，查看锁状态是否是偏向锁
 * @Date: Created In 15:52 2019/1/22
 */
public class SynchronizedTest1 {

    public static void main(String[] args)throws Exception{
        LockObject entity = new LockObject();
        //主线程先休息两分钟，方便我们通过HSDB工具类来查看线程栈中对象信息
        Thread.sleep(60000 * 2L);
        synchronized (entity){
            System.out.println("主线程获取到锁");
            try {
                //持有锁几分钟
                Thread.sleep(60000 * 2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程获释放锁");
        }

        System.out.println("主线程多休息一会，方便等待锁降级.");
        Thread.sleep(60000 * 100L);
    }
}
