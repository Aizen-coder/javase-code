package com.laner.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 */
public class ReflectionTest2 {

    /*
    如何操作运行时类中的指定的属性
     */

    @Test
    public void testField1() throws Exception {
        Class clazz=Person.class;

        Person p=(Person)clazz.newInstance();

        Field name=clazz.getDeclaredField("name");

        name.setAccessible(true);

        name.set(p,"Tom");

        System.out.println(name.get(p));
    }


    /*
    如何操作运行时类中的指定的方法
     */
    @Test
    public void testMethod() throws Exception {
        Class clazz=Person.class;

        Person p=(Person) clazz.newInstance();

        Method show = clazz.getDeclaredMethod("show",String.class);

        show.setAccessible(true);

        Object returnValue=show.invoke(p,"CHN");

        System.out.println(returnValue);



        System.out.println("*************如何调用静态方法*****************");

        Method showDesc=clazz.getDeclaredMethod("showDesc");

        showDesc.setAccessible(true);

        Object returnVal=showDesc.invoke(Person.class);

        System.out.println(returnVal);


    }




    /*
    如何调用运行时类中的指定的构造器
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz=Person.class;

        Constructor constructor=clazz.getDeclaredConstructor(String.class);

        constructor.setAccessible(true);

        Person per=(Person) constructor.newInstance("Tom");

        System.out.println(per);
    }



}
