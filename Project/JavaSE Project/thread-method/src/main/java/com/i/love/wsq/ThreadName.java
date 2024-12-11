package com.i.love.wsq;

/**
 * @author baitao05
 */
public class ThreadName {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable, "线程1号").start();
        new Thread(myRunnable).start();
        new Thread(myRunnable, "线程3号").start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
