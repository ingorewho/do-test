package com.test.connect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ingore1992
 * @Description:
 * @Date: Created In 10:52 2019/1/23
 */
@RestController
public class ConnectTest {
    private AtomicInteger count = new AtomicInteger();
    @GetMapping("/test")
    public void test(){
        System.out.println(count.decrementAndGet());
        try {
            //休息较长时间，让线程阻塞挂起
            Thread.sleep(1000* 10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
