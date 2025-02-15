package com.ILoveWsq;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author baitao05
 */

@Configuration
@ComponentScan
public class AppConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppService appService = context.getBean(AppService.class);
        appService.printLogo();
        appService.printProperties();
        Integer nintendo = 2;

        switch (nintendo) {
            case 2: {
                
            }
        }
    }

}
