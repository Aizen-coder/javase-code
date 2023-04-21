package com.laner.java;

/**
 *使用同步代码块解决实现Runnable接口方式的线程安全问题
 */
class Window1 implements Runnable{
    int ticket=100;
    @Override
    public void run() {
        while (true){
            synchronized(this){
                if (ticket>0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window1 w1=new Window1();
        Thread t1=new Thread(w1);
        Thread t2=new Thread(w1);
        Thread t3=new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
