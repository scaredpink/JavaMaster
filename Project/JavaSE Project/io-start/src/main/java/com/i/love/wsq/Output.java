package com.i.love.wsq;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author baitao05
 */
public class Output {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter(new File("/Users/baitao/JavaMaster/Project/JavaSE Project/io-start/src/main/resources/a.txt"));
        writer.append("hi你好");
        writer.close();
    }
}
