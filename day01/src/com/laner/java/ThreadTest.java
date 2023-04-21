package com.laner.java;

/**
 *   多线程的创建，方式一：继承于Thread类
 *  *1. 创建一个继承于Thread类的子类
 *   2. 重写Thread类的run()方法 --> 将此线程执行的操作声明在run()方法中
 *  *3. 创建Thread类的子类的对象
 *   4. 通过此对象调用start()
 *  <p>
 *  例子：遍历100以内的所有的偶数
 *
 */

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2. 重写Thread类的run()
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                /*用这种方式创建的线程还可以这样输出，因为currentThread()是Thread静态的方法，本类作为
                Thread的子类，当然可以这样调用这种方法
                 */
                //System.out.println(currentThread().getName()+":"+i);

            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Thread类子类的对象
        MyThread t1=new MyThread();
        //4.通过此对象调用start():①启动当前线程 ② 调用当前线程的run()
        t1.start();

        //再启动一个线程，需要重新创建一个线程的对象。每new一次就是在创建一个新线程
        MyThread t2=new MyThread();
        t2.start();

        //如下操作仍然是在main线程中执行的。
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":*********main()*******");
            }
        }

    }
}


