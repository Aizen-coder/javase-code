package IoBookTest.dao;

import IoBookTest.domain.Student;

import java.io.*;
import java.util.ArrayList;

/*
StudentDao:存储数据，增删改查操作（库管）
1、思考：存储数据的方式？
    存储方式：数组、集合、本地文件、数据库
    不同存储的区别：

        数组：需要声明存储元素个数，当超过容量后再添加逻辑复杂，程序结束数据丢失
        集合：自动调整容量，添加时逻辑简单，程序结束数据丢失

        本地文件：通过IO将存储学生对象的集合或者数组对象保存到本地，下次程序运行可以读取之前的数据
        数据库：后面再学
    思考：
        使用IO存储到本地文件时，文件中存什么数据？学生对象？数组对象？集合对象？
            存储学生对象：
                如何存多个对象到文件中？
                    测试存储对象的方法writeObject(Object o)是增量还是覆盖写入？
            存储数组对象
                使用数组的弊端是什么？
                    数组添加满后再添加学生对象时逻辑复杂
            存储集合对象
                学生的增删改查操作如何体现？答：集合的增删改查元素操作
                    引申：选用哪种集合？List？Set？Map？
                        如果经常对学生进行查询操作选择哪种集合？ArrayList?LinkedList?如果经常增删改呢？
    以上分析可以得出：
        类的成员：
            属性：
                集合：存储学生对象，同时保存到文件中
                    ArrayList<Student> students
                文件对象：存储路径在Java程序的体现
                    File file = new File("D:/StudentMS.info")
            行为：
                写入到文件
                    writeFile()
                读取文件内容到程序
                    readFile()
                集合的增删改查
                    addStudent、deleteStudent、updateStudent、selectAll、selectByName、selectBySid


2、对学生操作有增删改查，这些操作对集合的影响？集合的这些影响对文件有什么影响？
    增删改：修改集合中元素
        增：集合中添加元素
        删：集合中删除元素
        改：
           思考如何修改集合中的元素？
                先找到元素删除再重新添加？还是直接修改？
                不同的集合实现逻辑不同：
                    List、Set、Map如何替换某个元素？
    查：从集合取元素，需要读取文件中的集合对象
3、首次运行和非首次运行有什么不同？
    存储的文件是否存在？
        存在：直接使用
        不存在：需要先创建
    增：
        首次：直接添加
        非首次：需要先从文件中取出集合对象，然后在这个对象中添加新的元素
    删：
        首次：集合为空
        非首次：需要先从文件中取出集合对象，然后在这个对象中删除指定元素
    改：
        首次：找不到学生对象
        非首次：需要先从文件中取出集合对象，然后在这个对象找到指定元素后修改
    查：从集合取元素，需要读取文件中的集合对象
 */
public class StudentDao {
    //数组：数组知识点
    //Student[] students = new Student[5];
    //集合：集合知识点
    //泛型知识点
    //static关键字知识点
    public static ArrayList<Student> students = new ArrayList<Student>();
    /*
    存储路径对象
        思考：为什么用static修饰
     */
    static File file = new File("D:/StudentMS.obj");

    /*
    文件不存在时如何处理？
        什么时候创建文件？
     */
    static{
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    写入集合对象到文件中
     */
    public static void writeFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));//创建对象输出流
        oos.writeObject(students);//写出对象到文件中,注意写什么对象
        oos.flush();
        oos.close();
    }

    /*
    从文件中读取集合对象并赋值给students
     */
    public static void readFile() throws IOException, ClassNotFoundException {
        //当文件为空时，输入流未读取到任何数据,会报java.io.EOFException异常
        if(file.length() != 0 ) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object o = ois.readObject();//得到Object对象，需要强转为ArrayList<Student>类型
            if(o instanceof ArrayList) {
                students = (ArrayList<Student>) o;
            }
            ois.close();
        }

    }

    /*
    添加学生到集合:
        第一次运行程序添加？非第一次运行程序添加
     */
    public static void addStudent(Student s) throws IOException, ClassNotFoundException {
        //非第一次运行需要先从文件中取出历史数据
        readFile();//取出集合对象赋值给students
        students.add(s);//然后添加
        writeFile();//再写入到文件
    }

    /*
    删除学生：通过学生id删除学生
     */
    public static void deleteStudent(int sid) throws IOException, ClassNotFoundException {
        readFile();//取出集合对象赋值给students
        for(int i = 0 ; i< students.size();i++){
            if(students.get(i).getSid() == sid){
                students.remove(students.get(i));
            }
        }
        writeFile();//再写入到文件
    }

    /*
    修改学生信息：
        如何修改？删除再添加?直接替换？不同集合如何实现？
        Arraylist:
            删除再添加：元素的顺序是否有影响？
            直接替换:找到要修改的学生对象对应的下标，然后set(index,newStudent)修改
     */
    public static void updateStudent(int sid,Student news) throws IOException {
        int index = 0;
        //遍历集合找到元素的下标
        for(Student s:students){
            if(s.getSid() == sid){
                //int index = students.indexOf(students);//这样写index的作用域导致不能在循环外使用
                index = students.indexOf(s);
            }
        }
        //替换指定位置的元素
        System.out.println(index);
        students.set(index,news);
        writeFile();//再写入到文件
    }
    /*
    查看所有学生信息
     */
    public static void selectAll() throws IOException, ClassNotFoundException {
        //查询时需要从文件中取出集合对象，然后从集合对象取出所有元素
        readFile();//取出集合对象赋值给students
        System.out.println("编号\t姓名\t年龄\t性别");
        for(Student s:students){
            System.out.println(s);
        }
    }

    /*
    通过name查看单个学生信息
     */
    public static void selectByName(String sname) throws IOException, ClassNotFoundException {
        //查询时需要从文件中取出集合对象，然后从集合对象取出元素
        readFile();//取出集合对象赋值给students
        System.out.println("编号\t姓名\t年龄\t性别");
        for(Student s:students){
            if(s.getSname().equals(sname)){
                System.out.println(s);
            }

        }
    }

    /*
    通过id查看单个学生信息
     */
    public static void selectBysid(int sid) throws IOException, ClassNotFoundException {
        //查询时需要从文件中取出集合对象，然后从集合对象取出元素
        readFile();//取出集合对象赋值给students
        System.out.println("编号\t姓名\t年龄\t性别");
        for(Student s:students){
            if(s.getSid() == sid){
                System.out.println(s);
            }

        }
    }
}
