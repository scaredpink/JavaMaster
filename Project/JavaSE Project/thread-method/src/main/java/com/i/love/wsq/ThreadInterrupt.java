package com.i.love.wsq;

/**
 * @author baitao05
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread("曼波线程");
        t.start();
        Thread.sleep(10);
        t.interrupt();
        System.out.println("曼波被打断了");
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.printf("第%d次哦耶%n", n);
        }
    }
}