package com.i.love.wsq;

/**
 * @author baitao05
 */
public class ThreadSleep {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i ++ ) {
            new Thread(() -> {
                for (int j = 0; j < 10; j ++) {
                    System.out.println(Thread.currentThread().getName() + "-" + j);
                    try {
                        Thread.sleep(0, 1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }, "线程" + i).start();
        }
    }
}
