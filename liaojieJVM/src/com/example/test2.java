package com.example;

public class test2 {
    public static void main(String[] args) {
        new Thread(()->{

        },"my thread").start();
    }
    //native：凡是带了native关键字的，说明java作用范围达不到了，会去调用底层c语言的库
    //会进入本地方法栈
    //调用本地方法本地接口 JNI
    //
    private native void start0();
}
