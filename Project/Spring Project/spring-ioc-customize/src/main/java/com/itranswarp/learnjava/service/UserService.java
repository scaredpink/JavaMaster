package com.itranswarp.learnjava.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itranswarp.learnjava.validator.Validators;

@Component
public class UserService {

    @Autowired
    MailService mailService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    Validators validators;

    public UserService(@Autowired MailService mailService) {
        this.mailService = mailService;
    }

    public User login(String email, String password) {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id,email,password,name FROM spring_user WHERE email=? AND password=?")) {
                ps.setObject(1, email);
                ps.setObject(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        User user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
                        mailService.sendLoginMail(user);
                        return user;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("login failed");
    }

    public User getUser(long id) {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id,email,password,name FROM spring_user WHERE id=?")) {
                ps.setObject(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        User user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
                        return user;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User register(String email, String password, String name) {
        Long id = null;
        User user = null;
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id,email,password,name FROM spring_user WHERE email=?")) {
                ps.setObject(1, email);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        throw new RuntimeException("email existed");
                    }
                }
            }


            try (PreparedStatement ps = conn.prepareStatement("SELECT id FROM spring_user ORDER BY id DESC LIMIT 1")) {
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        id = rs.getLong(1) + 1;
                    }
                }
            }

            if (Objects.nonNull(id)) {
                user = new User(id, email, password, name);
            }

            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO spring_user (id, email, password, name) VALUES (?, ?, ?, ?)")) {
                if (Objects.isNull(user)) {
                    return null;
                }
                ps.setObject(1, user.getId());
                ps.setObject(2, user.getEmail());
                ps.setObject(3, user.getPassword());
                ps.setObject(4, user.getName());
                ps.executeUpdate();
                mailService.sendRegistrationMail(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
