package com.tlb;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        tenDown();
        Date start=new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(start));
                start=new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void tenDown() throws InterruptedException {
        int num=10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0)break;
        }
    }
}
