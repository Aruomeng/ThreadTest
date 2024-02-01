package com.tianyuhang.create.runnable;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 10:58
 */
// TODO:必须保证一个线程a在操作ticket的过程中，其他线程必须等待，直到线程a操作ticket的结束以后，其他线程才可以进入继续操作ticket


class SaleTickets implements Runnable{
    int ticket = 100;
    Object object = new Object();
    @Override
    public void run(){

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object){//对象必须唯一
                if(ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"-售票,票号为"+ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}
public class TicketsTest_Runnable {
    public static void main(String[] args) {
        SaleTickets saleTickets = new SaleTickets();

        Thread t1 = new Thread(saleTickets);
        Thread t2 = new Thread(saleTickets);
        Thread t3 = new Thread(saleTickets);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();


    }
}

