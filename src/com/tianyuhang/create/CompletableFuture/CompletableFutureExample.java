package com.tianyuhang.create.CompletableFuture;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 10:54
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) {
        // 创建一个CompletableFuture对象
        CompletableFuture<String> future = new CompletableFuture<>();

        // 异步任务
        CompletableFuture.runAsync(() -> {
            try {
                // 模拟耗时操作
                Thread.sleep(2000);
                // 完成异步任务并设置结果
                future.complete("Task completed successfully!");
            } catch (InterruptedException e) {
                // 出现异常时完成任务并设置异常结果
                future.completeExceptionally(e);
            }
        });

        // 主线程可以执行其他操作
        System.out.println("Main thread is doing some other work...");
        for (int i = 1; i <= 500 ; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }

        try {
            // 阻塞等待异步任务的完成，并获取结果
            String result = future.get();
            System.out.println("Async task result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}


