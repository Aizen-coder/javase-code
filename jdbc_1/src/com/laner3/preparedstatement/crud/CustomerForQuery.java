package com.laner3.preparedstatement.crud;

import com.laner2.util.JDBCUtils;
import com.laner3.bean.Customer;
import org.junit.Test;
//import com.mysql.jdbc.PreparedStatement;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

//import com.mysql.jdbc.Connection;

/**
 *针对于Customers表的查询操作
 */
public class CustomerForQuery {

    @Test
    public void testQueryForCustomers(){
        String sql="select id,name,birth,email from customers where id=?";
        Customer customer=queryForCustomers(sql,13);
        System.out.println(customer);

        sql="select name,email from customers where name=?";
        Customer customer1 = queryForCustomers(sql, "周杰伦");
        System.out.println(customer1);
    }

    public Customer queryForCustomers(String sql,Object...args){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            //1.获取连接
            conn= JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps= conn.prepareStatement(sql);
            //3.填充占位符
            for (int i=0;i< args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            //4.执行,并返回结果集
            rs=ps.executeQuery();
            //5.获取结果集的元数据
            ResultSetMetaData rsmd= rs.getMetaData();
            //6.通过ResultSetMetaData获取结果集中的列数
            int columnCount =rsmd.getColumnCount();

            if (rs.next()){
                Customer cust=new Customer();
                //处理结果集一行数据中的每一个列
                for (int i=0;i<columnCount;i++){
                    //获取列值
                    Object columValue=rs.getObject(i+1);

                    //获取每个列的列名
                    String columnLabel=rsmd.getColumnLabel(i+1);

                    //给cust对象指定的columnName属性，赋值为columValue：通过反射
                    Field field=Customer.class.getDeclaredField(columnLabel);
                    //保证当前属性是可访问的
                    field.setAccessible(true);
                    //设定此对象的此属性
                    field.set(cust,columValue);

                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }


        return null;
    }
}
