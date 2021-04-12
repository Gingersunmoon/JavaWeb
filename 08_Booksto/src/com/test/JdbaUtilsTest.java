package com.test;

import com.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbaUtilsTest {
    @Test
    public void TestJdba(){
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
        JdbcUtils.rollbackAndClose();
    }
}
