package exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *  在List内去除重复数字值，要求尽量简单
 */
public class CollectionTest {
    public static List duplicateList(List list){
        HashSet set=new HashSet();
        return new ArrayList(set);
    }

    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));

        List list2=duplicateList(list);

        for (Object integer:list){
            System.out.println(integer);
        }

    }

    @Test
    public void test2(){
        HashSet set=new HashSet();
        Person p1 = new Person(1001,"AA");//这里去定义一个Person类
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name="CC";
        set.remove(p1);
        System.out.println(set);

        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);
    }





}
