package com.i.love.wsq;

import com.i.love.wsq.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author baitao05
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.register("test@example.com", "password", "test");
        userService.login("test@example.com", "password");
        System.out.println(userService.getClass().getName());
    }
}
