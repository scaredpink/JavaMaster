package com.i.love.wsq;


import com.i.love.wsq.config.DatabaseConfig;
import com.i.love.wsq.service.UserService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.time.ZoneId;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author baitao05
 */

@Configuration
@ComponentScan
@PropertySource("classpath:/app.properties")
@PropertySource("classpath:/smtp.properties")
@PropertySource("classpath:/database.properties")
public class AppConfig {
    @Autowired
    DatabaseConfig databaseConfig;

    @Bean
    ZoneId createZoneId(@Value("${app.zone:Z}") String zoneId) {
        return ZoneId.of(zoneId);
    }

    @Bean
    DataSource createDataSource() {
        HikariConfig config = databaseConfig.getConfig();
        return new HikariDataSource(config);
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("bob@example.com", "password");
    }

}
