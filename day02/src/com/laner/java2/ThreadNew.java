package com.laner.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。 --- JDK 5.0新增
 */
//1.创建一个实现Callable的实现类
class NumThread implements Callable{
//2.实现call方法，将此线程需要执行的操作声明在call()中

    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i=1;i<=100;i++){
            if (i%2==0){
                sum+=i;
            }
        }
        return sum;//如果对这个返回值不感兴趣，可以返回null。
    }
}

public class ThreadNew<sout> {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread=new NumThread();
        //4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask=new FutureTask(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try{
            Object sum=futureTask.get();
            System.out.println("总和为："+sum);
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
