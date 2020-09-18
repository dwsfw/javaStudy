package com.example.reflection;

public class test02 {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class<?> aClass = Class.forName("com.example.reflection.User");
//        System.out.println(aClass);
//        Class<String> stringClass = String.class;
//        System.out.println(stringClass);
        System.out.println(A.m);
        A a=new A();
        System.out.println(A.m);
    }
}
class User{
    private String name;
    int id;

    @Override
    public String toString() {
        return "com.example.reflection.User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    int age;
}

class A{
    static {
        System.out.println("1111");
        m=300;
    }
    static int m=100;

    public A() {
        System.out.println("22222");
    }
}
