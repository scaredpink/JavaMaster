package com.ILoveWsq;

import com.ILoveWsq.service.UserService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * @author baitao
 */

@Configuration
@ComponentScan
public class AppConfig {
    private static final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private static final UserService userService = context.getBean(UserService.class);

    @Bean
    DataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/springDB?autoReconnect=true&amp;useSSL=false");
        config.setUsername("springUser");
        config.setPassword("password");
        // 连接超时：1秒
        config.addDataSourceProperty("connectionTimeout", "1000");
        // 空闲超时：60秒
        config.addDataSourceProperty("idleTimeout", "60000");
        // 最大连接数：10
        config.addDataSourceProperty("maximumPoolSize", "10");
        return new HikariDataSource(config);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你的想要完成的功能：");
        System.out.println("1:登录");
        System.out.println("2:注册");
        System.out.println("3:退出");
        while (scan.hasNext()) {
            String input = scan.nextLine();
            if (input.equals("1")) {
                System.out.println("请输入邮箱:");
                String email = scan.nextLine();
                System.out.println("请输入密码:");
                String password = scan.nextLine();
                userService.login(email, password);
            }
            if (input.equals("2")) {
                System.out.println("请输入邮箱:");
                String email = scan.nextLine();
                System.out.println("请输入密码:");
                String password = scan.nextLine();
                System.out.println("请输入昵称:");
                String name = scan.nextLine();
                userService.register(email, password, name);
            }
            if (input.equals("3")) {
                System.out.println("拜拜~");
                return;
            }
        }
    }
}
