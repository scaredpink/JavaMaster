package com.i.love.wsq;

import java.time.LocalDateTime;

/**
 * @author baitao05
 */
public class ThreadDaemon {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("用户线程异常");
            }
            System.out.println("用户线程结束");
        });

        Thread daemonThread = new Thread(() -> {
            while(true) {
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();

    }
}


