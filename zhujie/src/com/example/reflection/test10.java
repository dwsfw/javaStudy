package com.example.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class test10 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.example.reflection.Stu");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解的value
        table annotation = (table) c1.getAnnotation(table.class);
        String value=annotation.value();
        System.out.println(value);

        Field name = c1.getDeclaredField("name");
        field annotation1 = name.getAnnotation(field.class);
        System.out.println(annotation1.columName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());
    }

}
@table("db_student")
class Stu{
    @field(columName = "db_id",type = "int",length =10)
    private int id;
    @field(columName = "db_age",type = "int",length =10)
    private int age;
    @field(columName = "db_name",type = "varchar",length =3)
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
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

    public Stu() {
    }

    public Stu(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}
//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface table{
    String value();
}
//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface field{
    String columName();
    String type();
    int length();
}