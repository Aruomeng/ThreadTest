package com.tianyuhang.create.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 11:10
 */
class Window extends Thread{
    static int ticket = 100;
    //创建Lock的实例，多个线程共用一个Lock
    private static final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run(){
        while (true){
            try{
                lock.lock();
                if(ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+
                            "售票,票号为"+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {

        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

