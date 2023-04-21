package com.laner1.connection;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 */
public class ConnectionTest {
    @Test
    public void testConnection1() throws SQLException, ClassNotFoundException {
        Driver driver =new Driver(); //Driver，sun公司定义的接口中的一个

        //创建connect()方法中的两个参数
        String url ="jdbc:mysql://localhost:3306/test";   //url定位符
        Properties info =new Properties();
        info.setProperty("user","root");        //用户名和密码
        info.setProperty("password","root");

        //获取连接
//        Connection conn= DriverManager.getConnection(url,"root","root");  //将异常抛出。编译时调用的这个方法时sun公司的方法，真正要执行时是重写的方法
        Connection conn = driver.connect(url, info);
        //手动添加加载mysql驱动，连接mysql

        System.out.println(conn);

    }

    @Test
    public void getConnection() throws Exception {
        //1.读取配置文件中的4个基本信息

        //获取类的加载器
        //作为配置文件
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        //加载is文件
        pros.load(is);

        //获取4个基本信息
        String user=pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);


    }

}
