package com.itranswarp.learnjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DbInitializer {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        System.out.println("init table...");
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS users (" + //
                "id BIGINT IDENTITY NOT NULL," + //
                "email VARCHAR(100) NOT NULL," + //
                "password VARCHAR(100) NOT NULL," + //
                "name VARCHAR(100) NOT NULL," + //
                "PRIMARY KEY (id)," + //
                "UNIQUE (email))");
    }
}
