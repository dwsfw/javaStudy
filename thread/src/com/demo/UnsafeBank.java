package com.demo;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account=new Account(1000,"基金");
        Drawing you = new Drawing("you",account,50);
        Drawing girl=new Drawing("girl",account,100);
        you.start();
        girl.start();
    }
}
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class Drawing extends Thread{

    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(String name, Account account, int drawingMoney) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    @Override
    public void run() {
        synchronized (account){
            if(account.money-drawingMoney<0){
                System.out.println("钱不够");
                return;
            }
            account.money=account.money-drawingMoney;
            nowMoney=nowMoney+drawingMoney;
            System.out.println(account.name+"余额为"+account.money);
            //this.getName=Thread.currentThread().getName()
            System.out.println(this.getName()+"手里的钱"+nowMoney);
        }
    }
}