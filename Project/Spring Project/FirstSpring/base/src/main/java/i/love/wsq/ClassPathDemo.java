package i.love.wsq;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ClassUtils;

/**
 * @author baitao05
 */
public class ClassPathDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("1. ClassLoader: " + ClassPathDemo.class.getClassLoader());
        System.out.println("2. ClassLoader: " + ClassUtils.getDefaultClassLoader());
    }
}
