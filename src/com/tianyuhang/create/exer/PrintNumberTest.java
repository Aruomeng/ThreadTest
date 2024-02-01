package com.tianyuhang.create.exer;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 14:42
 */
// TODO:数据共享
class PrintNumber implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                notifyAll();
                if(number<=100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        wait();//线程进入等待，同时释放对同步监视器的调用
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }
    }
}
public class PrintNumberTest {
    public static void main(String[] args) {

        PrintNumber printNumber = new PrintNumber();

        Thread t1 = new Thread(printNumber,"线程1");
        Thread t2 = new Thread(printNumber,"线程2");
        Thread t3 = new Thread(printNumber,"线程3");

        t1.start();
        t2.start();
        t3.start();

    }
}

