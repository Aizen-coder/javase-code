package IoBookTest.Controller;

import IoBookTest.dao.StudentDao;
import IoBookTest.domain.Student;
import IoBookTest.service.StudentService;

import java.io.IOException;
import java.util.Scanner;

/**
 *  StudentController:和用户打交道（客服接待）
 */
public class StudentController {
    Scanner sc = new Scanner(System.in);
    //主界面
    public void mainInteface() throws IOException, ClassNotFoundException {
        System.out.println("欢迎使用学生管理系统");
        System.out.println("请选择操作类型");
        System.out.println("1、添加学生信息");
        System.out.println("2、删除学生信息");
        System.out.println("3、修改学生信息");
        System.out.println("4、查看学生信息");
        System.out.println("5、退出管理系统");

        int flag = sc.nextInt();
        switch (flag){
            case 1:
                add();
                break;
            case 2:
                delete();
                break;
            case 3:
                update();
                break;
            case 4:
                select();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("输入错误，请重新输入");
                break;
        }
        mainInteface();
    }

    //添加界面
    public void add() throws IOException, ClassNotFoundException {
        System.out.println("=====开始添加学生信息======");
        System.out.println("请输入学生sid");
        int sid = sc.nextInt();
        //判断输入的sid是否已经存在
        if(StudentService.sidIsExists(sid) != null){
            System.out.println(sid + "学生信息已存在,请重新输入");
            add();
        }else {
            System.out.println("请输入学生姓名");
            String sname = sc.next();
            System.out.println("请输入学生年龄");
            int age = sc.nextInt();
            System.out.println("请输入学生性别");
            String sex = sc.next();
            Student s = new Student(sid, sname, age, sex);
            StudentDao.addStudent(s);
        }
    }

    //删除界面
    public void delete() throws IOException, ClassNotFoundException {
        System.out.println("=====开始删除学生信息======");
        System.out.println("请输入要删除的学生sid");
        int sid = sc.nextInt();
        //判断输入的sid是否已经存在
        if(StudentService.sidIsExists(sid) != null){
            StudentDao.deleteStudent(sid);
        }else{
            System.out.println(sid + "学生不存在，请重新输入");
            delete();
        }

    }
    //修改界面
    public void update() throws IOException, ClassNotFoundException {
        System.out.println("=====开始修改学生信息======");
        System.out.println("请输入要修改的学生sid");
        int sid = sc.nextInt();
        Student oldStudent = StudentService.sidIsExists(sid);
        //判断输入的sid是否已经存在
        if(oldStudent != null){
            System.out.println("请输入修改后学生姓名(" + oldStudent.getSname() + "):");
            String sname = sc.next();
            System.out.println("请输入修改后学生年龄(" + oldStudent.getAge() + "):");
            int age = sc.nextInt();
            System.out.println("请输入修改后学生性别(" + oldStudent.getSex() + "):");
            String sex = sc.next();
            Student newStudent = new Student(sid,sname,age,sex);
            StudentDao.updateStudent(sid,newStudent);
        }else{
            System.out.println(sid + "学生不存在，请重新输入");
            update();
        }
    }
    //查看界面
    public void select() throws IOException, ClassNotFoundException {
        System.out.println("请输入查看方式：");
        System.out.println("1、查看所有学生信息");
        System.out.println("2、根据学生编号查看学生信息");
        System.out.println("3、根据学生姓名查看学生信息");
        int selectFlag = sc.nextInt();
        switch (selectFlag){
            case 1:
                StudentDao.selectAll();
                break;
            case 2:
                System.out.println("请输入要查看的学生编号");
                int sid = sc.nextInt();
                if(StudentService.sidIsExists(sid) != null){
                    StudentDao.selectBysid(sid);
                }else{
                    System.out.println("未学生编号"+ sid +"对应的信息");
                }

                break;
            case 3:
                System.out.println("请输入要查看的学生姓名");
                String sname =sc.next();
                if(StudentService.snameIsExists(sname)!= null){
                    StudentDao.selectByName(sname);
                }else{
                    System.out.println("找到"+ sname + "的学生");
                }

                break;
            default:
                System.out.println("输入错误，请重新输入");
                select();
        }

    }
}
