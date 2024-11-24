package com.ILoveWsq.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MailService {
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
