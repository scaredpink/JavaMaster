package i.love.wsq;

import sun.awt.windows.ThemeReader;

public class Main {
    private static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        Allocator allocator = new Allocator();
        Account a = new Account(allocator);
        Account b = new Account(allocator);
        Account c = new Account(allocator);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i ++ ) {
                a.transfer(b, 100);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i ++ ) {
                b.transfer(c, 100);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        a.printBalance();
        b.printBalance();
        c.printBalance();
    }
}
