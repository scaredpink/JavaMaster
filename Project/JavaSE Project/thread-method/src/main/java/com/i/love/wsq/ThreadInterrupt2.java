package com.i.love.wsq;

/**
 * @author baitao05
 */
public class ThreadInterrupt2 {
    public static void main(String[] args) throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(1);
        t.running = false;
    }
}

class HelloThread extends Thread {
    public volatile boolean running = true;
    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello");
        }
        System.out.println("end");
    }
}