package com.i.love.wsq;

/**
 * @author baitao05
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("【主线程】结束");
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        Thread mbt = new ManBoThread();
        mbt.start();
        try {
            mbt.join();
        } catch (InterruptedException e) {
            System.out.println("【MyThread线程】MyThread被打断了");
        }
        mbt.interrupt();
    }
}

class ManBoThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.printf("曼波%d\n", n);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("【曼波线程】曼波线程被打断了");
                break;
            }
        }
    }
}