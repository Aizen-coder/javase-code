package com.laner.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);

        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //1.contains(Object obj):判断当前集合中是否包含obj。集合中的每个元素都要与obj进行对比判断
        boolean contains=coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry",20)));//重写equals之前是false


        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection coll1= Arrays.asList(123,4567); //Arrays.asList,将数组中的一些元素转为集合
        System.out.println(coll.containsAll(coll1));
    }


    @Test
    public void test2(){
        //3.remove(Object obj):从当前集合中移除obj元素。返回的是布尔型的值，移除成功返回true，移除失败返回false
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        coll.remove(1234);
        System.out.println(coll);

        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4. removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。eg：移除的是这两个集合所共有的元素，并返回给当前集合，将剩下的值赋值给原集合
        Collection coll1=Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }


    @Test
    public void test3(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1=Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        Collection coll1=new ArrayList();
        coll1.add(456);
        coll1.add(123);
        coll1.add(new Person("Jerry",20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));//因为声明的ArrayList()是有序的，所以即便两个集合中的内容一样，但是如果顺序不同，两个集合还是不相等的

    }


    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 --->数组：toArray()		将集合转换为数组
        Object[] arr=coll.toArray();
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

        //数组 --->集合:调用Arrays类的静态方法asList()。
        List list=Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(list);

        List arr1=Arrays.asList(new int[]{123,456});
        System.out.println(arr1);

        List arr2=Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2);

    }







}
