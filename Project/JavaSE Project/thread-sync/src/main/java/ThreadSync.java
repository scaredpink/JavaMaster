/**
 * @author baitao05
 */
public class ThreadSync {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Thread t1 = new Thread(c1::add);
        Thread t2 = new Thread(c1::dec);
        Thread t3 = new Thread(c2::add);
        Thread t4 = new Thread(c2::dec);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println(c1.count);
        System.out.println(c2.count);
    }
}

class Counter {
    public int count = 0;

    public void add() {
        synchronized (Counter.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println("【加】开始");
                this.count++;
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {

                }
                System.out.println("【加】结束");
            }
        }
    }

    public void dec() {
        synchronized (Counter.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println("【减】开始");
                this.count--;
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {

                }
                System.out.println("【减】结束");
            }
        }
    }
}