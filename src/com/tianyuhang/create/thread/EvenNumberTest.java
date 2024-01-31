package com.tianyuhang.create.thread;

/**
 * @Author:田宇航
 * @Date: 2024/1/31 14:14
 */
class PrintNumber extends Thread {

    public PrintNumber(){

    }
    public PrintNumber(String name){
        super(name);
    }

    @Override
    public  void run(){
        for (int i = 1; i <= 100 ; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +":"+
                        Thread.currentThread().getPriority()+ ":" + i);
            }
//            if(i % 20 ==0){
//                Thread.yield();//主动释放CPU执行权
//            }
        }
    }
}

public class EvenNumberTest {

    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber("线程1");
        printNumber.setPriority(Thread.MIN_PRIORITY);

        printNumber.start();//创建线程


        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);//优先级，有更大概率启用



//        printNumber.run();//只是调方法，没有创建线程，同时一个main线程

        //main()为主线程
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +":"+
                        Thread.currentThread().getPriority()+ ":" + i);
            }

//            if(i == 20){
//                try {
//                    printNumber.join();//等待线程执行完毕后，再执行主线程
//                    System.out.println("线程1执行完毕");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
//        System.out.println("主线程1是否存活？"+printNumber.isAlive());


    }
}

