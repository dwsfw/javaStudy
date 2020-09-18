package com.tlb;

import javax.swing.plaf.TableHeaderUI;

//实现runnable接口
public class Test1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("run"+i);
        }
    }

    public static void main(String[] args) {
        Test1 test1=new Test1();
        new Thread(test1).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("mian"+i);
        }
    }
}
