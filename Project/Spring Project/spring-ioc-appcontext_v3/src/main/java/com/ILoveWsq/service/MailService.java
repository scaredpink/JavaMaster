package com.ILoveWsq.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private ZoneId zoneId = ZoneId.systemDefault();

    @Value("【使用@Value注入信息】")
    String message;
    @PostConstruct
    public void init() {
        System.out.println("Init mail service with zoneId = " + this.zoneId);
        System.out.println(message);
    }


    @PreDestroy
    public void shutdown() {
        System.out.println("Shutdown mail service");
    }

    public String getTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(dateTimeFormatter);
    }

    public void sendLoginMessage(User user) {
        System.err.printf("Hi, %s! You have logged in at %s%n", user.getName(), getTime());
    }

    public void sendRegistrationMessage(User user) {
        System.err.printf("Welcome, %s!%n", user.getName());
    }
}
