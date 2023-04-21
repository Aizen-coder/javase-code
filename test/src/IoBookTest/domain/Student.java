package IoBookTest.domain;

import java.io.Serializable;

/**
 * Student类:封装学生信息
 */
public class Student implements Serializable {
    //序列化一个类时，为了确保修改了类的信息后还能从原文件中获取到该对象，需要指定相同的序列化版本
    private static final long serialVersionUID = 1;
    /*
    private:私有化属性
    权限修饰符知识点
    封装：面向对象特征
        引申知识点：
            面向对象特征有哪些
                再引申：
                    详细介绍下面向对象特征
    int：
    数据类型知识点：
        基本数据类型
            整数型                  浮点型        字符型  布尔型
            byte、short、int、long、double、float、char、boolean
            引申知识点：
                基本类型的包装类
                    再引申：
                        拆箱、装箱
        引用数据类型
            类：String、集合、自定义类
            接口：
            数组：
            思考：Null是不是引用数据类型？
                 引用类型还有一种特殊的 null 类型
                 空类型（null type）就是 null 值的类型，这种类型没有名称。
                 因为 null 类型没有名称，所以不可能声明一个 null 类型的变量或者转换到 null 类型。
                 空引用（null）是 null 类型变量唯一的值。空引用（null）可以转换为任何引用类型。
                 在实际开发中，程序员可以忽略 null 类型，假定 null 只是引用类型的一个特殊直接量
    sid:变量名
    变量知识点：什么是变量？格式？常见修饰符
        引申知识点
            常量
     */
    private int sid;//学生编号
    private String sname;//学生姓名
    private int age;//学生年龄
    private String sex;//性别

    /*
    无参构造器作用:new Student()时会调用无参构造器，创建对象
    构造器知识点：
        1、系统会默认给我们提供一个无参构造方法。但如果我们自己写了构造方法，那么系统就不会再提供默认的无参构造方法了。
        2、在执行子类的构造方法之前，会先调用父类的构造方法，帮助子类完成初始化工作。
           如果没有用 super() 来调用父类特定的构造方法，则会调用父类的无参构造器。
        3、和类名相同，没有返回值，也没有void
     */
    public Student() {
        //super的含义：父类的
        super();//调用父类的构造器，不写系统默认也会去调用，显式声明时必须要写第一行
    }
    /*
    有参构造器：创建对象的同时对对象的属性赋值
     */
    public Student(int sid, String sname, int age, String sex) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.sex = sex;
    }

    /*
    方法:
    方法知识点：
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    /*
    toString():继承Object类的方法，在子类重写该方法
    知识点:
        1、Object类中该方法默认是输出对象的地址值
        2、在输出一个非null值对象时默认会调用该方法，
            思考输出一个null值对象时结果是什么？
     */
    @Override
    public String toString() {
        return sid + "\t" + sname+ "\t"  + age+ "\t" + sex;
    }
}
