package IoBookTest.service;

import IoBookTest.dao.StudentDao;
import IoBookTest.domain.Student;

import java.io.IOException;

/*
StudentService:业务的逻辑处理（业务员）
 */
public class StudentService {
    /*
判断id是否存在:
    这里判断sid是否存在其实是判断集合中是否存在某个元素的对象sid
    思考：如何获取到当前存储的集合对象
        static关键字作用

 */
    public static Student sidIsExists(int id) throws IOException, ClassNotFoundException {
        StudentDao.readFile();
        for(int i = 0;i<StudentDao.students.size();i++){
            if(StudentDao.students.get(i).getSid() == id){
                return StudentDao.students.get(i);
            }
        }
        return null;
    }

    public static Student snameIsExists(String name) throws IOException, ClassNotFoundException {
        StudentDao.readFile();
        for(int i = 0;i<StudentDao.students.size();i++){
            if(StudentDao.students.get(i).getSname().equals(name)){
                return StudentDao.students.get(i);
            }
        }
        return null;
    }
}
