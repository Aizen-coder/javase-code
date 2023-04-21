package com.laner.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *
 * 二、数组引用
 *
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    //Employee的空参构造器：Employee()
    @Test
    public void test1(){
        Supplier<Employee> sup= new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println("***************");


        Supplier<Employee>  sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("***************");

        Supplier<Employee>  sup2 = Employee::new;
        System.out.println(sup2.get());
    }


    //Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> func1=id->new Employee(id);
        Employee e1= func1.apply(1001);
        System.out.println(e1);

        System.out.println("*******************");
        Function<Integer,Employee> func2=Employee::new;
        Employee e2= func1.apply(1002);
        System.out.println(e2);
    }


    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> func1 = (id, name) -> new Employee(id,name);
        System.out.println(func1.apply(1001,"Tom"));


        System.out.println("*******************");

        BiFunction<Integer,String,Employee> func2 = Employee :: new;
        System.out.println(func2.apply(1002,"Tom"));
    }


    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> func1 = length -> new String[length];
        String[] arr1= func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        Function<Integer,String[]> func2 = String[] :: new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));



    }

}


