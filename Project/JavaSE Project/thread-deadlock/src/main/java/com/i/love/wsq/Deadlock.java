package com.i.love.wsq;

/**
 * @author baitao05
 */
public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(c::add);
        Thread t2 = new Thread(c::dec);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    public static int count = 0;
    public static Object lockA = new Object();
    public static Object lockB = new Object();

    public void add() {
        synchronized (lockA) {
            count ++;
            System.out.println("add-lockA");
            synchronized (lockB) {
                System.out.println("add-lockB");
            }
        }
    }

    public void dec() {
        synchronized (lockB) {
            count --;
            System.out.println("dec-lockB");
            synchronized (lockA) {
                System.out.println("dec-lockA");
            }
        }
    }
}
