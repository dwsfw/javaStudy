package com.example.reflection;

import java.lang.reflect.Field;

public class test06 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class aClass = Class.forName("com.example.reflection.User");
        System.out.println(aClass.getName());//类名+包名
        System.out.println(aClass.getSimpleName());//类名
        Field[] fields=aClass.getFields();//找到public属性
        fields=aClass.getDeclaredFields();//找到所以的属性
        for (Field field :
                fields) {
            System.out.println(field);
        }
    }
}
