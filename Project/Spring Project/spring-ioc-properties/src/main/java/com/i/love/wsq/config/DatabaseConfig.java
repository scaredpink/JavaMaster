package com.i.love.wsq.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author baitao05
 */
@Component
public class DatabaseConfig {
    @Value("${database.jdbcUrl}")
    private String jdbcUrl;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    @Value("${database.connectionTimeout}")
    private String connectionTimeout;
    @Value("${database.idleTimeout}")
    private String idleTimeout;
    @Value("${database.maximumPoolSize}")
    private String maximumPoolSize;

    public HikariConfig getConfig() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        // 连接超时：1秒
        config.addDataSourceProperty("connectionTimeout", connectionTimeout);
        // 空闲超时：60秒
        config.addDataSourceProperty("idleTimeout", idleTimeout);
        // 最大连接数：10
        config.addDataSourceProperty("maximumPoolSize", maximumPoolSize);
        return config;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(String connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public String getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(String idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public String getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(String maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }
}
