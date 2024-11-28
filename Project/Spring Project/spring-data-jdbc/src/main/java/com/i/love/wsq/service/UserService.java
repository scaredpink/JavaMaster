package com.i.love.wsq.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

/**
 * @author baitao
 */
@Component
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User getUserById(Long id) {
        return jdbcTemplate.execute((Connection conn) -> {
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT id,email,password,name FROM users WHERE id=?")) {
                pstmt.setLong(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        User user = new User();
                        user.setId(rs.getLong(1));
                        user.setEmail(rs.getString(2));
                        user.setPassword(rs.getString(3));
                        user.setName(rs.getString(4));
                        return user;
                    }
                    throw new RuntimeException("没有查询到id对应的用户");
                }
            }
        });
    }

    public User getUserByName(String name) {
        return jdbcTemplate.execute("SELECT id,email,password,name FROM users WHERE name=?",
                (PreparedStatement pstmt) -> {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getLong(1));
                    user.setEmail(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setName(rs.getString(4));
                    return user;
                }
                throw new RuntimeException("没有查询到Name对应的用户");
            }
        });
    }

    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT id,email,password,name FROM users WHERE name=?",
                (ResultSet rs, int rowNum) -> {
                    return new User(rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                }, email);
    }

    public Long getUsers() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM users", (ResultSet rs, int rowNum) -> {return rs.getLong(1);});
    }

    public List<User> getUsers(int pageIndex) {
        int limit = 100;
        int offset = limit * (pageIndex - 1);
        return jdbcTemplate.query("SELECT * FROM users LIMIT ? OFFSET ?",
                new BeanPropertyRowMapper<>(User.class),
                limit,offset);
    }

    public void updateUser(User user) {
        if (1 != jdbcTemplate.update("UPDATE users SET name = ? WHERE id = ?", user.getName(), user.getId())) {
            throw new RuntimeException("更新失败");
        }
    }

    public User register(String email, String password, String name) {
        // 创建KeyHolder
        KeyHolder keyHolder = new GeneratedKeyHolder();
        if (1 != jdbcTemplate.update((conn) -> {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (email, password, name) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            return pstmt;
        }, keyHolder)) {
            throw new RuntimeException("注册失败");
        }
        return new User(keyHolder.getKey().longValue(), email, password, name);
    }



}
