package com.laner.java1;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8中日期时间API的测试
 *
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date1=new Date(2023-1900,2-1,17);
        System.out.println(date1);
    }


    /*
    LocalDate、LocalTime、LocalDateTime 的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
        2.类似于Calendar
     */
    @Test
    public void test1(){
        //now():获取当前的日期、时间、日期+时间。静态方法
        LocalDate localDate =LocalDate.now();
        LocalTime localTime =LocalTime.now();
        LocalDateTime localDateTime =LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);


        //of():设置指定的年、月、日、时、分、秒。没有偏移量。静态方法
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 2, 17, 15, 19, 01);
        System.out.println(localDateTime1);


        //getXxx()：获取相关的属性。非静态方法
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());


        //体现不可变性
        //withXxx():设置相关的属性。非静态方法
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2=localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);


        //不可变性。非静态方法
        //plus加
        LocalDateTime localDateTime3=localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //minus减
        LocalDateTime localDateTime4 =localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }



    /*
    Instant的使用
    类似于 java.util.Date类

    */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);

        //添加时间的偏移量。非静态
        OffsetDateTime offsetDateTime=instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2023-02-17T15:34:55.831+08:00

        //toEpochMilli()非静态:获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        Long milli=instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli()静态:通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant1=Instant.ofEpochMilli(1676619482539L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat

    */
    @Test
    public void test3(){
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1=formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2023-02-17T15:42:38.379");
        System.out.println(parse);

        //方式二：
        //本地化相关的格式。如：ofLocalizedDateTime()。静态方法
        //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2023-2-17

        //重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);

        //解析
        TemporalAccessor accessor = formatter3.parse("2023-02-17 03:50:43");
        System.out.println(accessor);
    }


}
