package com.tianyuhang.create.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        // 创建一个固定大小的线程池，包含5个线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 提交10个任务给线程池执行
        for (int i = 1; i <= 10; i++) {
            MyTask task = new MyTask(i);
            executorService.submit(task);
        }

        // 关闭线程池
        executorService.shutdown();
    }
}

class MyTask implements Runnable {
    private int taskId;

    public MyTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("任务" + taskId +"号"+ " 正在线程 " + Thread.currentThread().getName()+"中运行");
        try {
            Thread.sleep(1000); // 模拟任务执行耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务" + taskId +"号"+ " 已完成在 " + Thread.currentThread().getName());
    }
}


