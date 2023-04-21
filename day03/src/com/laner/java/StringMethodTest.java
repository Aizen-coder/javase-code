package com.laner.java;

import org.junit.Test;

/**
 *
 */
public class StringMethodTest {

    @Test
    public void test4(){
        //String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
        String str1 = "雪却输梅一段白";
        String str2 = str1.replace('白', '香');

        System.out.println(str1);
        System.out.println(str2);

        //String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
        String str3 = str1.replace("段白", "长香");
        System.out.println(str3);

        System.out.println("*************************");
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        System.out.println("*************************");
        str = "12345";
        //判断str字符串中是否全部右数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);


        System.out.println("*************************");
        //String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }

    }


    @Test
    public void test3(){
        //boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
        String str1 = "hellowworld";
        boolean b1 = str1.endsWith("rld");
        System.out.println(b1);

        //boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
        boolean b2 = str1.startsWith("He");//
        System.out.println(b2);

        //boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
        boolean b3 = str1.startsWith("ll",2);
        System.out.println(b3);

        //boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
        String str2 = "wor";
        System.out.println(str1.contains(str2));//区分大小写

        //int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引。没找到返回-1
        System.out.println(str1.indexOf("lol"));

        //int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
        System.out.println(str1.indexOf("lo",5));

        String str3 = "hellorworld";
        //int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
        System.out.println(str3.lastIndexOf("or"));//索引还是从前往后的顺序
        //int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
        System.out.println(str3.lastIndexOf("or",6));

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str。情况二：不存在str
    }


    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        //boolean equals(Object obj)：比较字符串的内容是否相同
        System.out.println(s1.equals(s2));//区分大小写
        //boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));//不区分大小写

        //String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        //int compareTo(String anotherString)：比较两个字符串的大小
        //这时和怎么创建没有关系了
        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//涉及到字符串排序

        //String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
        String s7 = "返回一个新的字符串";
        String s8 = s7.substring(2);
        System.out.println(s7);
        System.out.println(s8);

        //String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
        String s9 = s7.substring(2, 5);
        System.out.println(s9);
    }

    @Test
    public void test1(){
        String s1 = "HelloWorld";
        //int length()：返回字符串的长度： return value.length
        System.out.println(s1.length());

        //char charAt(int index)： 返回某索引处的字符return value[index]
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
//        System.out.println(s1.charAt(10));
//        s1 = "";
        //boolean isEmpty()：判断是否是空字符串：return value.length == 0.空为true，不空为false
        System.out.println(s1.isEmpty());

        //String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
        //String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1不可变的，仍然为原来的字符串
        System.out.println(s2);//改成小写以后的字符串

        String s3 = "   he  llo   world   ";
        //String trim()：返回字符串的副本，忽略前导空白和尾部空白
        String s4 = s3.trim();
        System.out.println("-----" + s3 + "-----");
        System.out.println("-----" + s4 + "-----");
    }
}
