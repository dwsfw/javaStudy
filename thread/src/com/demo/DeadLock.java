package com.demo;

import java.util.HashMap;

//死锁，多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1=new Makeup(0,"g1");
        Makeup g2=new Makeup(1,"g2");
        g1.start();
        g2.start();
    }
}
//口红
class Lipstick{

}
//镜子
class Mirror{

}

class Makeup extends Thread{
    static Lipstick lipstick=new Lipstick();
    static  Mirror mirror=new Mirror();
    int choice;
    String girlname;

    public Makeup(int choice, String girlname) {
        this.choice = choice;
        this.girlname = girlname;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }
    private  void makeup() throws InterruptedException {
        if(choice==0){
            synchronized (lipstick){
                System.out.println(this.girlname+"获得口红的锁");
                Thread.sleep(1000);

            }
            synchronized (mirror){
                System.out.println(this.girlname+"获得镜子的锁");
            }
        }
        else {
            synchronized (mirror) {
                System.out.println(this.girlname + "获得镜子的锁");
                Thread.sleep(5000);

            }
            synchronized (lipstick) {
                System.out.println(this.girlname + "获得口红的锁");
            }
        }
    }
}
