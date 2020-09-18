package com.demo;


public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket test2=new BuyTicket();
        new Thread(test2,"小明").start();
        new Thread(test2,"老师").start();
        new Thread(test2,"黄牛").start();
    }
}
class BuyTicket implements Runnable{
    private int ticknums=1000;
    private boolean flag=true;
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void buy() throws InterruptedException {
        if(ticknums<=0){
            flag=false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+"拿到"+ticknums--);
    }

}