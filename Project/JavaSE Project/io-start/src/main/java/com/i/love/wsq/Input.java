package com.i.love.wsq;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @author baitao05
 */
public class Input {
    public static void main(String[] args) {
//        File f = new File("/Users/baitao/JavaMaster/Project/JavaSE Project/io-start/src/main/resources/a.txt");
        byte[] b = new byte[]{'H', 'e', 'l', 'l', 'o'};
//        try (InputStream inputStream = new FileInputStream(f)) {
        try (InputStream inputStream = new ByteArrayInputStream(b)) {
            System.out.println(readAsString(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readAsString(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(buffer)) != -1) {
            stringBuilder.append(new String(buffer, 0, len));
        }
        return stringBuilder.toString();
    }
}
