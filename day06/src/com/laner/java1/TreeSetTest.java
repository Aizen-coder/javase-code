package com.laner.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 */
public class TreeSetTest {
    @Test
    public void test1(){//自然排序
        TreeSet set =new TreeSet();
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){//定制排序
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1=(User) o1;
                    User u2=(User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet set=new TreeSet(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Mary",33));  //年龄相同时，谁先写就有谁，后写的就没有
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }


}
