package com.ILoveWsq.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private MailService mailService;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    //存放所有用户
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1L, "bob@example.com", "password", "2Bob"),
            new User(2L, "alice@example.com", "password", "Alice"),
            new User(3L, "tom@example.com", "password", "Tom")));

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                mailService.sendLoginMessage(user);
                return user;
            }
        }
        throw new RuntimeException("login failed");
    }

    public User getUser(long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User register(String email, String password, String name) {
        users.forEach(user -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email existed");
            }
        });

        User user = new User(users.stream().mapToLong(u -> u.getId()).max().getAsLong() + 1, email, password, name);
        users.add(user);
        mailService.sendRegistrationMessage(user);
        return user;
    }

}
