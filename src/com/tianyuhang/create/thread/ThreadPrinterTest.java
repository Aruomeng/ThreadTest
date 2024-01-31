package com.tianyuhang.create.thread;

/**
 * @Author:田宇航
 * @Date: 2024/1/31 14:26
 */

class PrinterEven extends Thread{//even
    @Override
    public void run(){
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }
}

class PrinterOdd extends Thread{//odd
    @Override
    public void run(){
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }
}
public class ThreadPrinterTest {
    public static void main(String[] args) {
        //method1
//        PrinterEven printerEven = new PrinterEven();
//        PrinterOdd printerOdd = new PrinterOdd();
//
//        printerEven.start();
//        printerOdd.start();

        //method2:创建thread的匿名对象
        new Thread(){
            public void run(){
                for (int i = 1; i <= 100 ; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "->" + i);
                    }
                }
            }

        }.start();

        new Thread(){
            public void run(){
                for (int i = 1; i <= 100 ; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "->" + i);
                    }
                }
            }

        }.start();


    }
}

