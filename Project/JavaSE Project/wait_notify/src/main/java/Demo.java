import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author baitao05
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        AtomicLong num = new AtomicLong();
        for (int i = 0; i < 3; i ++ ) {
            new Thread(() -> {
                System.out.printf("【%s】数据的加法运算: %d \n", Thread.currentThread().getName(), num.addAndGet(100));
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("【计算完成】结果是：" + num);
    }
}
