package com.laner.java;

import org.junit.Test;

/**
 * 获取Class的实例的方式（前三种方式需要掌握）  ---获取运行时类
 */
public class ReflectionTest {


    @Test
    public void test1() throws Exception {
        //方式一：调用运行时类的属性：.class
        Class clazz1=Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象,调用getClass()
        Person p=new Person();
        Class clazz2=p.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)    这个用的多
        Class clazz3=Class.forName("com.laner.java.Person");

        //判断地址值，是否指向同一个对象
        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader=ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("com.laner.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1==clazz4);
    }



}
