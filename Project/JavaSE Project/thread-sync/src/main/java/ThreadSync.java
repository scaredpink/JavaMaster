/**
 * @author baitao05
 */
public class ThreadSync {
    public static void main(String[] args) throws InterruptedException {
        Thread ad = new AddThread();
        Thread dd = new DecThread();
        ad.start();
        dd.start();
        ad.join();
        dd.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    public static int count = 0;
    public static final Integer lock = 1;
}

class AddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i ++ ) {
            synchronized (Counter.lock) {
                Counter.count ++;
            }
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i ++ ) {
            synchronized (Counter.lock) {
                Counter.count --;
            }
        }
    }
}