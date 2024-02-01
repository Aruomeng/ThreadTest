package com.tianyuhang.create.exer;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 15:19
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer pro1 = new Producer(clerk,"生产者1");
        Consumer con1 = new Consumer(clerk,"消费者1");
        Consumer con2 = new Consumer(clerk,"消费者2");


        pro1.start();
        con1.start();
        con2.start();

    }
}
class Clerk{
    private int productNum = 0;

    public synchronized void Add(){
        if (productNum>=20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            productNum++;
            System.out.println(Thread.currentThread().getName() + "生产了第"+productNum + "个");
            notifyAll();
        }
    }
    public synchronized void Minus(){

        if (productNum<=0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "消费了第"+productNum + "个");
            productNum--;
            notifyAll();
        }

    }
}
class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk,String name){
        super(name);
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("生产者开始生产产品...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.Add();
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk,String name){
        super(name);
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("消费者开始消费产品...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.Minus();
        }
    }
}


