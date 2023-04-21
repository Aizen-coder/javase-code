package com.laner.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *RandomAccessFile的使用
 */
public class RandomAccessFileTest {
    @Test
    public void test1(){
        RandomAccessFile raf1=null;
        RandomAccessFile raf2=null;

        try{
            raf1=new RandomAccessFile(new File("10.JPG"),"r");
            raf2=new RandomAccessFile(new File("10-1.JPG"),"rw");

            byte[] buffer=new byte[1024];
            int len;
            while ((len=raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (raf1!=null){
                try{
                    raf1.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if (raf2!=null){
                try{
                    raf1.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test2() throws IOException {

        RandomAccessFile raf=new RandomAccessFile(new File("hello.txt"),"rw");

        raf.seek(3);
        raf.write("xyz".getBytes());

        raf.close();
    }



    /*
    使用RandomAccessFile实现数据的插入效果
     */

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf=new RandomAccessFile("hello.txt","rw");

        raf.seek(3);
        StringBuilder builder=new StringBuilder((int) new File("hello.txt").length());

        byte[] buffer=new byte[20];
        int len;
        while((len=raf.read(buffer))!=-1){
            builder.append(new String(buffer,0,len));
        }

        raf.seek(3);

        raf.write("xyz".getBytes());
        raf.write(builder.toString().getBytes());

        raf.close();


    }


}
