package com.bt;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Main {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
    public static final String USER = "learn";
    public static final String PASSWORD = "learnpassword";
    public static DataSource dataSource;


    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10
        dataSource = new HikariDataSource(config);

        // 获取连接
        try (Connection conn =  dataSource.getConnection()) {
            // 创建语句
            try (Statement stmt = conn.createStatement()) {
                //执行查询
                try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=\'1\'")) {
                    while (rs.next()) {
                        long id = rs.getLong(1); // 注意：索引从1开始
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        System.out.println(id + ", " + grade + ", " + name + ", " + gender);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}