package com.example.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//分析性能问题
public class test08 {
    public static void test01(){
        User user =new User();
        long start=System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long end=System.currentTimeMillis();

        System.out.println("普通方式执行10亿次："+(end-start)+"ms");
    }
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user =new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        long start=System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long end=System.currentTimeMillis();

        System.out.println("反射执行10亿次："+(end-start)+"ms");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user =new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long start=System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long end=System.currentTimeMillis();

        System.out.println("关闭安全检查 反射执行10亿次："+(end-start)+"ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
