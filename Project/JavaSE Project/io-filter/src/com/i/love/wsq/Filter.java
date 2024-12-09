package com.i.love.wsq;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author baitao05
 */
public class Filter {
    public static void main(String[] args) {
        byte[] data = "Man! what can I say?".getBytes(StandardCharsets.UTF_8);
        try (InputStream input = new ByteArrayInputStream(data)) {
            try (InputStream input2 = new BufferedInputStream(input)) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
