package com.tianyuhang.create.runnable;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 11:55
 */
// TODO: 使用同步方法解决实现Runnable接口线程安全问题

class SaleTickets1 implements Runnable{
    int ticket = 200;
    boolean isFlag = true;
    @Override
    public void run(){
        while (isFlag){
            show();
        }
    }
    public synchronized void show(){
        if(ticket > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"-售票,票号为"+ticket);
            ticket--;

        }else {
            isFlag = false;
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {

        SaleTickets1 s = new SaleTickets1();

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();


    }

}

