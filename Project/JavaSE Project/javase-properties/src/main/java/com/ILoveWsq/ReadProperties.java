package com.ILoveWsq;


import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.util.Properties;

/**
 * @author baitao
 */

public class ReadProperties {
    public static void main(String[] args) throws Exception {
        // 从项目根目录读取配置
        Properties properties = new Properties();
        properties.load(new FileReader("file.properties"));
        System.out.println(properties.get("name"));
        System.out.println(properties.get("message"));
        System.out.println("----------");

        // 从resource读取配置
        properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("example.properties"));
        System.out.println(properties.get("name"));
        System.out.println(properties.get("message"));
        System.out.println("----------");

        // 从内存读取配置
        String settings = "name=Memory" + "\n" + "message=this is from Memory";
        ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
        properties.load(input);
        System.out.println(properties.get("name"));
        System.out.println(properties.get("message"));
    }

}
