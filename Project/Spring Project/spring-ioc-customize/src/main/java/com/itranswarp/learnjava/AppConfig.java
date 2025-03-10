package com.itranswarp.learnjava;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.time.ZoneId;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.itranswarp.learnjava.service.MailSession;
import com.itranswarp.learnjava.service.User;
import com.itranswarp.learnjava.service.UserService;

@Configuration
@ComponentScan
public class AppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.register("sam@example.com", "password", "Sam");
        User user = userService.login("sam@example.com", "password");
        System.out.println(user.getName());
        context.getBean(MailSession.class);
        context.getBean(MailSession.class);
        context.getBean(MailSession.class);
        ((ConfigurableApplicationContext) context).close();
    }

    @Bean
    @Primary
    @Qualifier("z")
    ZoneId createZoneOfZ() {
        return ZoneId.of("Z");
    }

    @Bean
    @Qualifier("utc8")
    ZoneId createZoneOfUTC8() {
        return ZoneId.of("UTC+08:00");
    }

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
}
