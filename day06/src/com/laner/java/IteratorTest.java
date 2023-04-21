package com.laner.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator= coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test2(){    //测试Iterator中的remove()
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator =coll.iterator();

        //删除集合中"Tom"
        while(iterator.hasNext()){
            Object obj=iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();
            }
        }

        System.out.println(coll);

        iterator=coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }




}
