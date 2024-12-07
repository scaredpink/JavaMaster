package com.i.love.wsq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @author baitao05
 */
public class CopyFile {
    public static void main(String[] args) {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        System.err.println(Arrays.toString(args));

        try (InputStream input = new FileInputStream(file1);
            OutputStream output = new FileOutputStream(file2)
        ) {
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = input.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
