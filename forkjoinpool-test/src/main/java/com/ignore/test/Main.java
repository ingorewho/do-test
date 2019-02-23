package com.ignore.test;

import com.ignore.forkjoin.task.PrintTask;
import com.ignore.forkjoin.task.SumTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ignore1992
 * @Description: 测试ForkJoinPool
 * @Date: 2019/2/23
 */
public class Main {
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();
        PrintTask printTask = new PrintTask(0, 1000);
        pool.submit(printTask);
        pool.awaitQuiescence(2, TimeUnit.SECONDS);
        SumTask sumTask = new SumTask(0, 1000);
        ForkJoinTask<Integer> result = pool.submit(sumTask);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
