package i.love.wsq;

import java.util.Map;
import java.util.Objects;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        Map<String, String> map = null;
        System.out.println(Objects.isNull(map) || map.get(0)== "123");
    }
}
