package com.example.reflection;
//测试类什么时候初始化
public class test04 {
    static {
        System.out.println("Main被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        主动引用
//        Son son=new Son();
//        反射也会产生主动引用
//        Class.forName("com.example.reflection.Son");
//        不会产生类的引用的方法
//        System.out.println(Son.b);
//        Son[] a=new Son[5];

    }
}
class Father{
    static int b=2;
    static {
        System.out.println("父类加载");
    }
}
class Son extends Father{
    static {
        System.out.println("子类加载");
        m=300;
    }
    static int m=100;
    static final int M=1;
}
