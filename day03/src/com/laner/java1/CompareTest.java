package com.laner.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
 *
 *  *
 * 二、Comparable接口与Comparator的使用的对比：
 *  *  Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 *  *  Comparator接口属于临时性的比较。
 */
public class CompareTest {
    @Test
    public void test1(){
        String[] arr=new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test2(){
        Goods[] arr=new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /*
    Comparator接口的使用：定制排序
     */

    @Test
    public void test3(){
        String[] arr=new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator() {
            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof  String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                //return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test4(){
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("huaweiMouse",224);
        arr[5] = new Goods("microsoftMouse",43);

        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())) {
                        return -Double.compare(g1.getPrice(), g2.getPrice());
                    } else {
                        return g1.getName().compareTo(g2.getName());
                    }

                }
                throw new RuntimeException("输入的数据类型不一致");

            }
        });
        System.out.println(Arrays.toString(arr));
    }


}
