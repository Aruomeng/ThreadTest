package com.tianyuhang.create.exer;

/**
 * @Author:田宇航
 * @Date: 2024/2/1 13:08
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();

        Customer customer1 = new Customer(account,"甲",1000);
        Customer customer2 = new Customer(account,"乙",1500);

        customer1.start();
        customer2.start();

    }
}
class Account{
    private double balance;
    public synchronized void deposit(double amt){
        if(amt > 0){
            balance+= amt;
        }
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName()+"存钱"+amt+"元，余额为："+balance);
    }
}
class Customer extends Thread{
    Account account;
    double amt;

    public Customer(Account account,String name,double amt){
        super(name);
        this.account = account;
        this.amt = amt;
    }
    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.deposit(amt);
        }
    }
}

