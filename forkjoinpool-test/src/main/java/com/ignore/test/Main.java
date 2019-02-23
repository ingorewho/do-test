package com.ignore.test;

import com.ignore.forkjoin.task.PrintTask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ignore1992
 * @Description: 测试ForkJoinPool
 * @Date: 2019/2/23
 */
public class Main {
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();
        PrintTask task = new PrintTask(0, 1000);
        pool.submit(task);
        pool.awaitQuiescence(2, TimeUnit.SECONDS);
    }
}
