package com.laner.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class ForTest {//for-each测试
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        for (Object obj:coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        coll.forEach(System.out::println);
    }


    @Test
    public void test3(){//用foreach循环遍历数组
        int[] arr=new int[] {1,2,3,4,5,6};
        for (int i:arr){
            System.out.println(i);
        }
    }





}
