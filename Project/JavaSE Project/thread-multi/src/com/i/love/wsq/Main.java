package com.i.love.wsq;

/**
 * @author baitao05
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("【主线程】嘟嘟");
        Thread t = new Thread(() -> {
           System.out.println("【子线程】地地地道道");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("【子线程】地道道地道");
        });
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("【主线程】请让一让");
    }
}
