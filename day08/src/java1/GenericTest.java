package java1;

import org.junit.Test;

import java.util.*;

/**
 *
 */
public class GenericTest {

    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test1(){
        ArrayList<Integer> list =new ArrayList<Integer>();

        list.add(123);
        list.add(456);
        list.add(789);
        list.add(012);
        list.add(135);
        list.add(791);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
        System.out.println("***************");

        for(Integer score:list){
            int stuScore =score;
            System.out.println(stuScore);
        }

    }

        //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test2(){
        Map<String,Integer> map= new HashMap<>();//类型推断
        map.put("Tom",20);
        map.put("Jerry",19);
        map.put("Rose",18);
        map.put("Jack",25);

        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> subEntry= iterator.next();
            String key=subEntry.getKey();
            Integer values =subEntry.getValue();
            System.out.println(key+"--->"+values);
        }
    }
}
