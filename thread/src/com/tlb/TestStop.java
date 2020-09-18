package com.tlb;
//1、建议线程正常停止--》利用次数，不建议死循环
//2、建议使用标志位--》设置一个标志位
//3不使用stop或者destroy等过时或者jdk不建议使用的方法
public class TestStop  implements Runnable{

    boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while (flag)
            System.out.println("Run+"+i++);
    }
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestStop testStop=new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            if(i==9000) {
                testStop.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
