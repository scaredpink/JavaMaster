package com.i.love.wsq;

/**
 * @author baitao05
 */
public class ThreadWait {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i ++) {
            int finalI = i;
            threads[i] = new Thread(()-> {
                System.out.println("【子线程" + finalI + "】开始");
                System.out.println("【子线程" + finalI + "】结束");
            });
        }
        System.out.println("【主线程】开始");

        for (int i = 4; i >= 0; i --) {
            threads[i].start();

        }
        System.out.println("【主线程】结束");
    }
}
