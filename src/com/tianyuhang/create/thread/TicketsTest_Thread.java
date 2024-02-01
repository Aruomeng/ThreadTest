package com.tianyuhang.create.thread;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 11:10
 */

class Window extends Thread{
    static int ticket = 100;
    @Override
    public void run(){
        while (true){
            if(ticket > 0){
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+"-售票,票号为"+ticket);
                ticket--;
            }else {
                break;
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

