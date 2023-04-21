package com.laner.exer;

/**
 *
 */
public class StringTest {

    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        //值传递：基本数据类型传的是存的数据，引用数据类型传的是地址值。String具有不可变性
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}
