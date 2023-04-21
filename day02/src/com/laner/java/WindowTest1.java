package com.laner.java;
//
/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 */
class Window extends Thread{
    private static int ticket=100;
    @Override
    public void run() {
        while (true) {
            synchronized (Window.class){
                if (ticket > 0) {
                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }

}




public class WindowTest1 {
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

