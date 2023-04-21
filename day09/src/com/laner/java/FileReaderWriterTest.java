package com.laner.java;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 用FileReader 和 FileWriter进行复制文件的操作
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        //声明一个FileReader 和 FileWriter的对象
        FileReader fr=null;
        FileWriter fw=null;

        try{
            //1.实例化File
            File file=new File("D:\\workspace_idea1\\JavaSenior\\day09\\hello.txt");
            File dest=new File("D:\\workspace_idea1\\JavaSenior\\day09\\hello2.txt");

//            File file=new File("hello.txt");
//            File dest=new File("hello2.txt");

            //2.实例化FileReader 和 FileWriter
            fr=new FileReader(file);
            fw=new FileWriter(dest);

            //3.读入、写出操作
            char[] cbuf =new char[5];
            int len;
            while ((len= fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.关闭流
            try{
                if (fr!=null){
                    fr.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try{
                if (fw!=null){
                    fw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }



}
