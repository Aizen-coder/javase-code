package java1;

/**
 *  泛型类的使用
 */
public class GenericType {
    public static void main(String[] args) {
        Animal<Double> a1=new Animal<>("猫",1.5);
        a1.test(1.5);
        Animal<Integer> a2 =new Animal<>("大象",10);
        a2.test(10);
        System.out.println(a2.weight);
    }
}

class Animal<T extends Number>{
    String name;
    T weight;

    public Animal(String name, T weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void test(T number){
        System.out.println(number.getClass());
    }

    {
        T number;
    }

}


class Cat extends Animal{

    public Cat(String name, Number weight) {
        super(name, weight);
    }
}

