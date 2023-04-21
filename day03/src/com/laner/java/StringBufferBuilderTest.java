package com.laner.java;

import org.junit.Test;

/**
 *StringBufferBuilder方法
 */
public class StringBufferBuilderTest {

    @Test
    public void test2(){
        //StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);

        //StringBuffer delete(int start,int end)：删除指定位置的内容。只要涉及开始和结束位的，都是左闭右开
//        s1.delete(3,5);
//        System.out.println(s1);

        //StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
        s1.replace(3,5,"def");
        System.out.println(s1);

        //StringBuffer insert(int offset, xxx)：在指定位置插入xxx
        s1.insert(1,1);
        System.out.println(s1);

        //StringBuffer reverse() ：把当前字符序列逆转
//        s1.reverse();
//        System.out.println(s1);

        //public int indexOf(String str):返回指定子字符串在此字符串中最右边出现处的索引
        System.out.println(s1.indexOf("a1"));

        //public String substring(int start,int end):返回一个从start开始到end索引结束的左闭右开区间的子字符串
        String s2 = s1.substring(1, 3);
        System.out.println(s2);
    }



    @Test
    public void test1(){
        StringBuffer str1=new StringBuffer("abc");
        str1.setCharAt(0,'m');
        System.out.println(str1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());
    }
}
