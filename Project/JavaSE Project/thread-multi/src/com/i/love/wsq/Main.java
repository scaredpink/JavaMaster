package com.i.love.wsq;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("利用Runnable开始新线程");
        });
        t.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("开始了新线程");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("利用Runnable开始新线程");
    }
}
