package com.example;

import java.util.ArrayList;

public class test3 {
    byte[] array=new byte[1*1024*1024];
    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();

        long l1 = Runtime.getRuntime().totalMemory();

        System.out.println("max="+(l/(double)1024/1024)*4+"   total="+(l1/(double)1024/1024));
        //-Xms1024m -Xmx1024m -XX:+PrintGCDetails  修改内存 显示信息
        //-Xms1024m -Xmx1024m -XX:+HeapDumpOnOutOfMemoryError  dump文件
        ArrayList<test3> list=new ArrayList<>();
        int count=0;
        try {
            while (true) {
                list.add(new test3());
                count++;
            }
        }catch (Exception e){

        }

    }
}
