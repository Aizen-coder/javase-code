package com.laner.java1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 *  1. System类中currentTimeMillis();
 *  2. java.util.Date和子类java.sql.Date
 *  3. SimpleDateFormat
 *  4. Calendar
 */
public class DateTimeTest {

    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1 格式化：日期 --->字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2.SimpleDateFormat的实例化

    */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf=new SimpleDateFormat();

        //格式化：日期 --->字符串
        Date date=new Date();
        System.out.println(date);

        String format=sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str= "23-2-17 下午2:40";
        Date date1=sdf.parse(str);
        System.out.println(date1);

//*************按照指定的方式格式化和解析：调用带参的构造器*****************

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1=sdf1.format(date);
        System.out.println(format1);

        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),否则，抛异常
        Date date2=sdf1.parse("2014-06-20 07:07:07");
        System.out.println(date2);
    }


        /*
        字符串"2020-09-08"转换为java.sql.Date
         */



    @Test
    public void testExer() throws ParseException{
        String birth="2020-09-08";
        SimpleDateFormat sdf1=new SimpleDateFormat();
        Date date=sdf1.parse(birth);

        java.sql.Date birthDate=new java.sql.Date(date.getTime());
        System.out.println(birthDate);

    }


    /*
    Calendar日历类(抽象类）的使用

    */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar=Calendar.getInstance();

        //2.常用方法
        //get()
        int days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date =calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1=new Date();
        calendar.setTime(date1);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
