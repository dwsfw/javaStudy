package com.example.reflection;

public class test05 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //火气系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //获取扩展类加载器的父类加载器-->跟加载器（c/c++）直接获取不到
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        //测试当前类是哪个加载器加载到
        ClassLoader classLoader = Class.forName("com.example.reflection.test05").getClassLoader();
        System.out.println(classLoader);
        //测试jdk内置的类是哪个加载器加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        System.out.println(System.getProperty("java.class.path"));
    }
}
