package com.tianyuhang.create.exer;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 13:30
 */
public class BankTest {
    static Bank b1 = null;
    static Bank b2 = null;
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                b1 = Bank.getInstance();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                b2 = Bank.getInstance();
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);

    }
}

class Bank{
    private Bank(){
    }
    private static Bank instance = null;

//    public static synchronized Bank getInstance(){
//        if (instance == null){
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            instance = new Bank();
//        }
//        return instance;
//    }
    //方法2
    /*相当于厕所就一个隔间坑位，前两个线程想在隔间里小便，都在隔间前抢位置锁门，
    而第三个线程直接去小便池解决下就走了，并且小便池还可以同时让多个线程一起来小便，
    不用去抢坑位浪费时间*/
    public static Bank getInstance(){
        if (instance ==null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

