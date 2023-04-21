package com.laner.java;

import org.junit.Test;

/**
 * 通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest {

    @Test
    public void test1() throws Exception {
        Class<Person> clazz1=Person.class;

        Person obj=clazz1.newInstance();//类的泛型决定了newInstance()的返回值
        System.out.println(obj);

    }
}
