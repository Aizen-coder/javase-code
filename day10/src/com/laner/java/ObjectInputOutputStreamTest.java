package com.laner.java;

import org.junit.Test;

import java.io.*;

/**
 *
 */
public class ObjectInputOutputStreamTest {

    /*
     序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */

    @Test
    public void TestObjectOutputStream(){
        ObjectOutputStream oos=null;

        try{
            //1.
            oos=new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();

            oos.writeObject(new Person("高启强",25,1001,new Account(10000)));
            oos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (oos!=null){
                try{
                    oos.close();
                } catch (IOException e){
                e.printStackTrace();
                }
            }


        }
    }
/*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream来实现
 */
    @Test
    public void TestObjectInputStream(){
        ObjectInputStream ois=null;
        try{
            //1.
            ois=new ObjectInputStream(new FileInputStream("Object.dat"));

            //2.
            Object obj=ois.readObject();
            String str=(String) obj;

            Person p=(Person)ois.readObject();

            System.out.println(str);
            System.out.println(p);

        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally{
            if (ois!=null){
                try{
                    ois.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }




}
