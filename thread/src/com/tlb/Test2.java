package com.tlb;
//模拟网络的延时，放大问题的发生性
public class Test2 implements Runnable{

    private int ticknums=10;
    @Override
    public void run() {
        while (true){
            if(ticknums<=0)
                break;
//            try {
//                Thread.sleep(200);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticknums--+"张票");
        }
    }

    public static void main(String[] args) {
        Test2 test2=new Test2();
        new Thread(test2,"小明").start();
        new Thread(test2,"老师").start();
        new Thread(test2,"黄牛").start();
    }
}
