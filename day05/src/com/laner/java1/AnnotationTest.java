package com.laner.java1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person p=new Student();
        p.walk();

        //这里提示过时了
        Date date =new Date(2023,2,19);
        System.out.println(date);

        @SuppressWarnings("unused")
        int num=10;

        //System.out.println(num);  如果这个被注释掉，并且又没有注解时，num的颜色是浅的，在提出警告

        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list=new ArrayList();

    }
}


//jdk 8之前的写法：
//@MyAnnotations({@MyAnnotation(value="hi"),@MyAnnotation(value="hi")})
@MyAnnotation(value = "hi")
@MyAnnotation(value = "abc")
class Person{
    private String name;
    private int age;

    public Person(){
    }
    @MyAnnotation
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    @MyAnnotation
    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    void show();
}

class Student extends Person implements Info{

    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}

class Generic<@MyAnnotation T>{
    public void show(){
        ArrayList<@MyAnnotation String> list =new ArrayList<>();
        int num=(@MyAnnotation int)10L;
    }
}