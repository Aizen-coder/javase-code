package test1;

/**
 *
 */
public class test01 {
    public static void main(String[] args) {
        TestRunnable tRunnable = new TestRunnable();
        Thread ti = new Thread(tRunnable);
        ti.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("呱呱呱"+i);
        }
    }
}
class TestRunnable implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 50; i++) {
            System.out.println("嘎嘎噶"+i);
        }
    }
}