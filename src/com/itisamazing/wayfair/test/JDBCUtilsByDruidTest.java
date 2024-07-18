package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.utils.JDBCUtilsByDruid;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * 用来测试JDBC连接池是否跟数据库成功连接
 * 测试成功
 */
public class JDBCUtilsByDruidTest {

    @Test
    public void getConnection() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println("connection = " + connection);
        JDBCUtilsByDruid.close(null, null, connection);
    }

}
