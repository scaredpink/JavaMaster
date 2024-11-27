package com.ILoveWsq;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author baitao
 */

public class WriteProperties {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("message", "this is a properties written by Java");
        properties.store(new FileOutputStream("writeFile.properties", true), "写入注释");

    }
}
