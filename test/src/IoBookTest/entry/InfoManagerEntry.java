/*
包的注意事项
    包名命名规则：字母都是小写
    package语句必须是程序的第一条可执行的代码
    package语句在一个java文件中只能有一个
    如果没有package,默认表示无包名
    多级包之间使用 " . " 进行分割
 */
package IoBookTest.entry;
/*
为什么分这么多包？
    如果将所有的类文件都放在同一个包下,不利于管理和后期维护,所以,对于不同功能的类文件,可以放在不同的包下进行管理
知识点：分包思想
包名         存储的类                     作用
domain	    Student.java	            封装学生信息
dao	        StudentDao.java	            存储数据，增删改查操作（库管）
service	    StudentService.java	        业务的逻辑处理（业务员）
controller	StudentController.java	    和用户打交道（客服接待）
entry	    InfoManagerEntry.java	    程序的入口类，提供一个main方法
 */


import IoBookTest.Controller.StudentController;

import java.io.IOException;

/*
类的知识点：
    命名规则：每个单词首字母大写
类与类之间的访问 (理解)
    同一个包下的访问
        不需要导包，直接使用即可
    不同包下的访问
        1.import 导包后访问
        2.通过全类名（包名 + 类名）访问
    注意：import 、package 、class 三个关键字的摆放位置存在顺序关系
    package 必须是程序的第一条可执行的代码
    import 需要写在 package 下面
    class 需要在 import 下面
 */
public class InfoManagerEntry {
    /*
main方法：java程序的入口
    思考：一个程序能有几个入口？
 */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StudentController sc = new StudentController();
        sc.mainInteface();
    }
}
