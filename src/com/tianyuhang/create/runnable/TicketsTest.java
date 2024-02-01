package com.tianyuhang.create.runnable;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 10:58
 */

class SaleTickets implements Runnable{
    int ticket = 100;

    @Override
    public void run(){

        while (true){
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
public class TicketsTest {
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

