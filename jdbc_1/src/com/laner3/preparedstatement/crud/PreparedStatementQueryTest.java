package com.laner3.preparedstatement.crud;

import com.laner2.util.JDBCUtils;
import com.laner3.bean.Customer;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用PreparedStatement实现针对于不同表的通用的查询操作
 */
public class PreparedStatementQueryTest {
    @Test
    public void testgetForList(){
        String sql="select id,name,email from customers where id<?";
        List<Customer> list=getForList(Customer.class,sql,12);
        list.forEach(System.out::println);

    }


    public <T> List<T> getForList(Class<T> clazz,String sql,Object...args){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            //1.获取连接
            conn= JDBCUtils.getConnection();

            //2.预编译SQL语句
            ps=conn.prepareStatement(sql);

            //3.填充占位符
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            //4.执行，并返回结果集
            rs= ps.executeQuery();

            //5.获取结果集元素据
            ResultSetMetaData rsdm = rs.getMetaData();

            //6.获取列数
            int columnCount=rsdm.getColumnCount();

            //7.创建集合对象
            ArrayList<T> list=new ArrayList<>();

            while(rs.next()){
                //8.创建运行时类的对象
                T t= clazz.newInstance();
                //9.处理结果集一行数据中的每一个列:给t对象指定的属性赋值
                for (int i=0;i<columnCount;i++){
                    // 获取列值
                    Object columValues=rs.getObject(i+1);

                    // 获取每个列的列名
                    String columnLabel= rsdm.getColumnLabel(i+1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field=clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columValues);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }



}
