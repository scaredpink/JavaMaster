package i.love.wsq;

import java.io.IOException;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 5000; i ++ ) {
            str = str + i;
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("消耗时间: " + (endTime - startTime));
    }
}
