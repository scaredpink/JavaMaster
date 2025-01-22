package i.love.wsq;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.ResourceUtils;

/**
 * @author baitao05
 */
public class ResourceDemo {
    public static void main(String[] args) throws Exception {
        ResourceLoader loader = new DefaultResourceLoader();    // 实例化加载器
        Resource resource = loader.getResource("https://www.baidu.com"); // 加载文件
        Scanner scanner = new Scanner(resource.getInputStream());   // 获取输入流
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String result = scanner.next();
            System.out.println(result);
        }
        scanner.close();
    }
}
