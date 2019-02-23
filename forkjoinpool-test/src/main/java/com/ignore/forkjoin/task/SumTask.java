package com.ignore.forkjoin.task;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: ignore1992
 * @Description: 获取返回值
 * @Date: 2019/2/23
 */
public class SumTask extends RecursiveTask<Integer>{
    private int startIndex;
    private int endIndex;

    public SumTask(int startIndex, int endIndex){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if ((endIndex - startIndex) < 100){
            for (int i = startIndex; i < endIndex; i++){
                sum += i;
            }
        }else {
            int middle = (startIndex + endIndex)/2;
            SumTask leftTask = new SumTask(startIndex, middle);
            SumTask rightTask = new SumTask(middle, endIndex);
            leftTask.fork();
            rightTask.fork();
            //子任务返回结果相加
            return leftTask.join() + rightTask.join();
        }
        return sum;
    }
}
