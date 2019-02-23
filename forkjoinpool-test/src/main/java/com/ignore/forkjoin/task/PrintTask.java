package com.ignore.forkjoin.task;

import java.util.concurrent.RecursiveAction;

/**
 * @Author: ignore1992
 * @Description: 打印任务
 * @Date: 2019/2/23
 */
public class PrintTask extends RecursiveAction{
    private int startIndex;
    private int endIndex;

    public PrintTask(int startIndex, int endIndex){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    protected void compute() {
        if (endIndex - startIndex < 100){
            for (int i = startIndex; i < endIndex; i++){
                System.out.println(Thread.currentThread().getName() + "打印: " + i);
            }
        }else {
            int middle = (startIndex + endIndex)/2;
            PrintTask leftTask = new PrintTask(startIndex, middle);
            PrintTask rightTask = new PrintTask(middle, endIndex);
            //并行执行子任务
            leftTask.fork();
            rightTask.fork();
        }
    }
}
