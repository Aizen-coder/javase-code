package java1;

import org.junit.Test;

import java.util.*;

/**
 *
 */
public class MapTest {

        /*
 元视图操作的方法：//遍历Map集合的方法
 Set keySet()：返回所有key构成的Set集合
 Collection values()：返回所有value构成的Collection集合
 Set entrySet()：返回所有key-value对构成的Set集合

     */
    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);

        //遍历所有的key集：keySet()
        //System.out.println(map.keySet());
        Set set= map.keySet();
        for (Object obj:set){
            System.out.println(obj);
        }
        System.out.println();

        //遍历所有的value集：values()
        Collection coll= map.values();
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        System.out.println();

        //遍历所有的key-value。从entry中单独将key和value值取出来的方法
        //方式一：
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj=iterator1.next();
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }

        System.out.println();

        //方式二：
        Set keyset= map.keySet();
        Iterator iterator=keyset.iterator();
        while (iterator.hasNext()){
            Object key=iterator.next();
            Object value=map.get(key);
            System.out.println(key + "=====" + value);
        }
    }

        /*
 元素查询的操作：
 Object get(Object key)：获取指定key对应的value
 boolean containsKey(Object key)：是否包含指定的key
 boolean containsValue(Object value)：是否包含指定的value
 int size()：返回map中key-value对的个数
 boolean isEmpty()：判断当前map是否为空
 boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        // Object get(Object key)
        System.out.println(map.get(45));
        //containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        isExist = map.containsValue(123);
        System.out.println(isExist);

        map.clear();

        System.out.println(map.isEmpty());
    }

    /*
     添加、删除、修改操作：
 Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 void putAll(Map m):将m中的所有key-value对存放到当前map中
 Object remove(Object key)：移除指定key的key-value对，并返回value。如果remove中写的key在集合中不存在，输出的是null
 void clear()：清空当前map中的所有数据
     */
    @Test
    public void test3(){
        Map map=new HashMap();

        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //修改
        map.put("AA",789);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)。如果remove中写的key在集合中不存在，输出的是null
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //clear()
        map.clear();
        System.out.println(map.size());
        System.out.println(map);

    }

    @Test
    public void test2(){//演示LinkedHashMap按顺序输出的遍历
        Map map= new LinkedHashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");
        System.out.println(map);

    }

    @Test
    public void test1(){//测试HashMap可以存储null的key和value
        Map map=new HashMap();
        map.put(null,null);
        System.out.println(map);
    }
}
