package com.tianyuhang.create.runnable;

/**
 * @Author:田宇航
 * @Date: 2024/1/31 14:50
 */
class PrintNumber implements Runnable {
    @Override
    public  void run(){
        for (int i = 1; i <= 100 ; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }
}
public class EvenNumberTest {
    public static void main(String[] args) {

        PrintNumber printNumber = new PrintNumber();

        Thread thread = new Thread(printNumber);
        Thread thread2 = new Thread(printNumber);

        thread.start();
        thread2.start();

        for (int i = 1; i <= 100 ; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
        //使用Runnable接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100 ; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + "->" + i);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100 ; i++) {
                    if(i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + "->" + i);
                    }
                }
            }
        }).start();


    }
}

