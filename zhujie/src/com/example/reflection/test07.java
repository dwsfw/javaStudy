package com.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射 动态的创建对象
public class test07 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1= Class.forName("com.example.reflection.User");
//        User user=(User)c1.newInstance();//本质是调用User的无参构造器

//        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
//        User o = (User) constructor.newInstance("111", 001, 18);
//        System.out.println(o);
        User user3=(User)c1.newInstance();
//        Method setName = c1.getDeclaredMethod("setName", String.class);
//        setName.invoke(user3,"slhdf");
//        System.out.println(user3.getName());

        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);//
        name.set(user3,"1111");
        System.out.println(user3.getName());
    }
}
