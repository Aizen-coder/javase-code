package com.laner.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *通过FileInputStream和FileOutputStream写出复制文件的方法
 * 非字节流
 */
public class FileInputOutputStreamTest {

    public static void main(String[] args) {
        String srcPath ="D:\\workspace_idea1\\JavaSenior\\day09\\10.JPG";
        String destPath="D:\\workspace_idea1\\JavaSenior\\day09\\12.JPG";

        FileInputOutputStreamTest.copyFile(srcPath,destPath);
    }

    public static void copyFile(String srcPath, String destPath){
        FileInputStream fis=null;
        FileOutputStream fos=null;

        try{
            //1.
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);

            //2.
            fis=new FileInputStream(srcFile);
            fos=new FileOutputStream(destFile);

            //3.
            byte[] buffer=new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {

            //4.
            if (fis!=null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if (fos!=null){
                try{
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }




    }
}
