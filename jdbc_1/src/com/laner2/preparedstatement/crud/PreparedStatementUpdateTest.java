package com.laner2.preparedstatement.crud;

import com.laner2.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 */
public class PreparedStatementUpdateTest {
    @Test
    public void testCommonUpdate(){
        String sql="update `order` set order_name=? where order_id=?";
        update(sql,"DD",2);
    }



    public void update(String sql,Object...args){
        Connection conn=null;
        PreparedStatement ps=null;

        try {
            //1.获取数据库的连接
            conn= JDBCUtils.getConnection();

            //2.预编译sql语句，返回PreparedStatement的实例
            ps= conn.prepareStatement(sql);

            //3.填充占位符
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn,ps);
        }

    }
}
