package java1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GenericMethod {
//    public static void main(String[] args) {
//        GenericMethod a1=new GenericMethod();
//        System.out.println(a1.test(12));
//        System.out.println(a1.test("abc"));
//
//    }
//
//    public <T> T test(T a){
//        return a;
//    }

    //声明一个泛型方法
    public static <T extends Tuxing > void printArea (List < T > list) {
            for (T t:list){
                System.out.println(t.getArea());
            }
    }

    public static void main(String[] args) {
        List<Yuanxing> list1=new ArrayList<>();//类型推断
        list1.add(new Yuanxing(1));
        list1.add(new Yuanxing(2));
        printArea(list1);

        List<Juxing> list2=new ArrayList<>();
        list2.add(new Juxing(1, 2));
        list2.add(new Juxing(3, 4));
        list2.add(new Juxing(5, 6));
        printArea(list2);

        List<Tuxing> list3=new ArrayList<>();
        list3.add(new Yuanxing(3));
        list3.add(new Juxing(7, 8));
        printArea(list3);

    }
}





abstract class Tuxing{
    public abstract Double getArea();
}

class Yuanxing extends Tuxing{
    private double radius;

    public Yuanxing(double radius) {
        this.radius = radius;
    }

    @Override
    public Double getArea() {
        return Math.PI*radius*radius;
    }
}

class Juxing extends Tuxing{
    private int chang;
    private int kuan;

    public Juxing(int chang, int kuan) {
        this.chang = chang;
        this.kuan = kuan;
    }


    @Override
    public Double getArea() {
        return (double) (chang*kuan);
    }
}


