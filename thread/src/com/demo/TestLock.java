package com.demo;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 t=new TestLock2();
        new Thread(t,"t1").start();
        new Thread(t,"t2").start();
        new Thread(t,"t3").start();
    }
}
class TestLock2 implements Runnable{
    int ticketNums=10;
    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                if(ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }
                else break;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}
