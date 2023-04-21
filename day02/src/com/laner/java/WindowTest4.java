package com.laner.java;

/**
 *使用同步方法处理继承Thread类的方式中的线程安全问题
 */
class Window4 extends Thread{
    private static int ticket=100;
    @Override
    public void run() {
        while (true) {
             show();
        }
    }

    private static synchronized void show(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }

}




public class WindowTest4 {
    public static void main(String[] args) {
        Window w1=new Window();
        Window w2=new Window();
        Window w3=new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }

}




