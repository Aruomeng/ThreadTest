package com.tianyuhang.create.thread;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 11:10
 */
// FIXME:线程1操作ticket过程中，尚未结束的情况下，其他线程也参与进来对ticket的进行操作
    // TODO:必须保证一个线程a在操作ticket的过程中，其他线程必须等待，直到线程a操作ticket的结束以后，其他线程才可以进入继续操作ticket

    // TODO:synchronized(同步监视器)->锁，线程共用同一个

class Window extends Thread{
    static int ticket = 100;
    static Object object = new Object();//static修饰，可保证唯一性
    @Override
    public void run(){
        while (true){

            synchronized (object) {//不能填this，三个对象
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
public class TicketsTest_Thread {
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

