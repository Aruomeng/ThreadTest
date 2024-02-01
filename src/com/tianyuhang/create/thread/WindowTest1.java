package com.tianyuhang.create.thread;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 12:11
 */

class Window1 extends Thread{
    static int ticket = 100;
    static Object object = new Object();
    static boolean isFlag = true;
    @Override
    public void run(){
        while (isFlag){
            show();
        }
    }
    public static synchronized void show(){
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

        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }

}

