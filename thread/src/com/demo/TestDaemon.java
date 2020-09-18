package com.demo;

public class TestDaemon {
    public static void main(String[] args) {
        God god=new God();
        You you =new You();
        Thread thread=new Thread(god);
        thread.setDaemon(true);
        thread.start();
        new Thread(you).start();
    }
}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝一直存在");
        }
    }
}
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你开心的活在");
        }
        System.out.println("goodbye world!!!");
    }
}
