package i.love.wsq;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

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
        PropertySource mapSource = new MapPropertySource("url", data);

        Properties prop = new Properties();
        prop.setProperty("java", "现任");
        prop.setProperty("c++", "前任");
        PropertySource propertiesSource = new PropertiesPropertySource("language", prop);

        MutablePropertySources sources = new MutablePropertySources();
        sources.addLast(mapSource);
        sources.addLast(propertiesSource);
        log.info("属性资源获取: aaa={}", sources.get("url").getProperty("aaa"));
        log.info("属性资源获取: bbb={}", sources.get("url").getProperty("bbb"));
        log.info("属性资源获取: java={}", sources.get("language").getProperty("java"));
        log.info("属性资源获取: c++={}", sources.get("language").getProperty("c++"));

    }


}
