import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        String a = "2";
        List<String> b =new ArrayList<>();
        hello(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    private static void hello(String a, List<String> b) {
        a = "123";
        b.add("123");
    }
}
