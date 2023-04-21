package com.laner.java;

import org.junit.Test;

import java.io.*;

/**
 *  缓冲流：
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 */
public class BufferedTest {

    //使用BufferedReader和BufferedWriter实现文本文件的复制。
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //1+2.创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));  //因为只用一次，所以就用匿名的方式来写了
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //3.读写操作：使用String
            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);
                bw.newLine();

            }
        }catch (IOException e) {
                e.printStackTrace();
        } finally {
            //关闭资源
            if(bw != null){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(br != null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }



