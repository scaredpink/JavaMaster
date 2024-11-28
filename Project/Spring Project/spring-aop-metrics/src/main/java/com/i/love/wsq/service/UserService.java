package com.i.love.wsq.service;

import com.i.love.wsq.metrics.MetricTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author baitao
 */
@Component
public class UserService {

    @Autowired
    MailService mailService;


    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1L, "bob@example.com", "password", "2Bob"),
            new User(2L, "alice@example.com", "password", "Alice"),
            new User(3L, "tom@example.com", "password", "Tom")
    ));


    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                mailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed.");
    }

    public User getUser(long id) {
        return this.users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() ->new RuntimeException("没有找到用户"));
    }

    @MetricTime("register")
    public User register(String email, String password, String name) {
        users.forEach((user) -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist.");
            }
        });
        User user = new User(users.stream().mapToLong(User::getId).max().orElse(0) + 1, email, password, name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return user;
    }
}
