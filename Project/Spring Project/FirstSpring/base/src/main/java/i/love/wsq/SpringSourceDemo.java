package i.love.wsq;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author baitao05
 */
@Slf4j
public class SpringSourceDemo {
    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("aaa", "啊啊啊");
            put("bbb", "崩崩崩");
        }};
        PropertySource propertySource = new MapPropertySource("url", data);
        log.info("属性资源获取 aaa={}", propertySource.getProperty("aaa"));
    }
}
