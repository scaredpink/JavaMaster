package com.ILoveWsq;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author baitao05
 */

@Component
public class AppService {
    @Value("classpath:/logo.txt")
    private Resource resource;

    @Value("classpath:/app.properties")
    private Resource propertiesResource;

    private String logo;
    private String appName;
    private String appVersion;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] buffer = new byte[1024];
            int len = -1;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = inputStream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0 ,len));
            }
            logo = new String(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        properties.load(propertiesResource.getInputStream());
        appName = properties.getProperty("app.name");
        appVersion = properties.getProperty("app.version");
    }

    public void printLogo() {
        System.out.println(logo);
    }

    public void printProperties() {
        System.out.println("app.name = " + appName);
        System.out.println("app.version = " + appVersion);
    }
}
