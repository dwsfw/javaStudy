package com.example.reflection;

public class test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        person p=new student();
        Class<?> aClass = p.getClass();
        System.out.println(aClass.hashCode());
        Class<?> aClass1 = Class.forName("com.example.reflection.student");
        System.out.println(aClass1.hashCode());
        System.out.println(Integer.TYPE);
        System.out.println(aClass.getSuperclass());
    }
}
class person{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                '}';
    }

    public person() {
    }

    String name;
}

class student extends person{
    public student() {
        this.name="学生";
    }
}
class teacher extends person{
    public teacher() {
        this.name="老师";
    }
}