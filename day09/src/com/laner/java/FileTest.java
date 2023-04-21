package com.laner.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class FileTest {

    /*
        1.如何创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)

     */

    @Test
    public void test1(){
        //构造器1
        File file1= new File("hello.txt");
        File file2=new File("D:\\workspace_idea1\\JavaSenior\\day09");
        //仅仅是指定了路径

        System.out.println(file1);
        System.out.println(file2);

        //构造器2：
        File file3=new File("D:\\workspace_idea1\\JavaSenior","day09");

        //构造器3：
        File file4=new File(file3,"hi.txt");

    }


        /*
public String getAbsolutePath()：获取绝对路径
public String getPath() ：获取路径
public String getName() ：获取名称
public String getParent()：获取上层文件目录路径。若无，返回null
public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
public long lastModified() ：获取最后一次的修改时间，毫秒值

如下的两个方法适用于文件目录：
public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组


     */

    @Test
    public void test2(){
        File file1=new File("hello.txt");
        File file2=new File("D:\\workspace_idea1\\JavaSenior\\day09\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }

    /*
    如下的两个方法适用于文件目录：
    public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
    public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     */

    @Test
    public void test3(){
        File file =new File("D:\\workspace_idea1\\JavaSenior");

        String[] list=file.list();
        for (String name:list){
            System.out.println(name);
        }

        System.out.println("*****************");

        File[] listfile=file.listFiles();
        for(File name:listfile){
            System.out.println(name);
        }
    }


    /*

        public boolean renameTo(File dest):把文件重命名为指定的文件路径
     比如：file1.renameTo(file2)为例：
        要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。

		这个方法涉及到两个File类型的对象：1.调用这个方法的对象；2.形参

     */
    @Test
    public void test4(){
        File file=new File("D:\\workspace_idea1\\JavaSenior\\day09\\hello.txt");
        File dest=new File("D:\\workspace_idea1\\JavaSenior\\day09\\src\\com\\laner\\hi.txt");
        //输出后，hello.txt不见了，D:\workspace_idea1\JavaSenior\day09\src\com\laner中出现了hi.txt。
        //文本文件中的内容没有变化
        //作用相当于   剪切+重命名
        System.out.println(file.renameTo(dest));

    }


    /*

public boolean isDirectory()：判断是否是文件目录
public boolean isFile() ：判断是否是文件
public boolean exists() ：判断是否存在。   真正判断当前对象是不是在硬盘中存在对应的文件和文件目录
public boolean canRead() ：判断是否可读      对应的文件不一定是文本文件格式
public boolean canWrite() ：判断是否可写
public boolean isHidden() ：判断是否隐藏


     */

    @Test
    public void test5(){
        //针对文件  --- File对象中对应的是文件名
        File file1 = new File("hello.txt");
        file1 = new File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canWrite());
        System.out.println(file1.canRead());
        System.out.println(file1.isHidden());

        System.out.println();

        //针对文件目录
        File file2=new File("D:\\workspace_idea1\\JavaSenior\\day09\\src\\com\\laner\\hi.txt");
        System.out.println(file2.isDirectory());   //把hi.txt去掉就是目录了
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canWrite());
        System.out.println(file2.canRead());
        System.out.println(file2.isHidden());

        System.out.println();
    }



    /*
        创建硬盘中对应的文件或文件目录
public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建

    删除磁盘中的文件或文件目录
public boolean delete()：删除文件或者文件夹
    删除注意事项：Java中的删除不走回收站。

     */

    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");

        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7(){
        //文件目录的创建
        File file =new File("D:\\workspace_idea1\\JavaSenior\\day09\\io");
        if (file.mkdir()){
            System.out.println("file1创建成功");
        }

        File file2 = new File("D:\\workspace_idea1\\JavaSenior\\day09\\io\\io1\\io2");
        if (file2.mkdir()){
            System.out.println("file2创建成功");
        }

        File file3 =new File("D:\\workspace_idea1\\JavaSenior\\day09\\io\\io1\\io2");
        if (file3.mkdirs()){
            System.out.println("file3创建成功");
        }

        //要想删除成功，io1文件目录下不能有子目录或文件
        File file4=new File("D:\\workspace_idea1\\JavaSenior\\day09\\io\\io1");
        System.out.println(file4.delete());
    }


}
