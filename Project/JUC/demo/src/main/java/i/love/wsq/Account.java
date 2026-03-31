package i.love.wsq;

public class Account {
    // allocator需为单例
    private Allocator allocator;
    private int balance = 1000000000;

    void transfer(Account target, int amt) {
        allocator.apply(this, target);
        try {
            synchronized (this) {
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            allocator.free(this, target);
        }
    }

    synchronized void printBalance() {
        System.out.println(balance);
    }

    public Account(Allocator allocator) {
        this.allocator = allocator;
    }
}
