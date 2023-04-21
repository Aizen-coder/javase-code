package com.laner.exer;

import org.junit.Test;

/**
 *获取一个字符串在另一个字符串中出现的次数。
 *       比如：获取“ab”在 “abkkcadkabkebfkaabkskab” 中出现的次数
 */
public class StringDemo {

    @Test
    public void testgetcount() {
        String mainStr = "abkkcadkabkebfkaabkskab";
        String subStr = "ab";
        int count=getcount(mainStr,subStr);
        System.out.println(count);
    }

    public int getcount(String mainstr,String substr){
        int mainLength=mainstr.length();
        int subLength=substr.length();
        int count=0;
        int index=0;

        if (mainstr.length()>=substr.length()) {
            //方式一：
//            while ((index = mainstr.indexOf(substr)) != -1) {
//                count++;
//                mainstr=mainstr.substring(index + substr.length());
//            }
            //方式二：
            while((index =mainstr.indexOf(substr,index))!=-1) {
                count++;
                index+=substr.length();
            }

            return count;
        }else {
            return 0;
        }
    }
}
