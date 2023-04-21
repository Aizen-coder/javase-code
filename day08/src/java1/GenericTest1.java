package java1;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符
 */
public class GenericTest1 {
    public static void test(List<?> list){
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("abc");
        list.add("edf");
        test(list);
    }
}
