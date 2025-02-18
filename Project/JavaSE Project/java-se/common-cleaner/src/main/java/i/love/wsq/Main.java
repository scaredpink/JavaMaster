package i.love.wsq;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.stream().forEach(str -> str.equals(" "));
    }
}
