import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @author baitao05
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Book book = new Book("书", 520.47);
        AtomicReference<Book> ref = new AtomicReference<>(book);
        System.out.println("【修改结果】" +  ref.compareAndSet(book, new Book("书本", 123.45)));
        System.out.println(ref);
    }
}

class Book {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("标题为%s, 价格为%f\n", title, price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}