package com.ILoveWsq.service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ILoveRIRIKA
 */

@Component
public class UserService {
    @Autowired
    private MailService mailService;
    @Autowired
    private DataSource dataSource;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    //存放所有用户
//    private List<User> users = new ArrayList<>(Arrays.asList(
//            new User(1L, "bob@example.com", "password", "2Bob"),
//            new User(2L, "alice@example.com", "password", "Alice"),
//            new User(3L, "tom@example.com", "password", "Tom")));

    public User login(String email, String password) {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id,email,password,name FROM spring_user WHERE email=? AND password=?")) {
                ps.setObject(1, email);
                ps.setObject(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        User user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
                        mailService.sendLoginMessage(user);
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
                mailService.sendRegistrationMessage(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
