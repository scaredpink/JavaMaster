import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        List<Short> a = new ArrayList<>();
        System.out.println(a.stream().map(Objects::toString).collect(Collectors.toList()));

        List<Short> b = new ArrayList<>();
        b.add((short) 3);
        System.out.println(new HashSet<>(a).containsAll(b));

        System.out.println(11000186 % 512);
    }
}
