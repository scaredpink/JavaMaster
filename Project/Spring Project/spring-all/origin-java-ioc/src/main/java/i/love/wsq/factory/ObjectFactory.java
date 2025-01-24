package i.love.wsq.factory;

import i.love.wsq.Main;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectFactory {
    //业务接口实例池
    private static final Map<String, Object> INSTANCE_POOL_MAP = new HashMap<>();
    // static代码块做初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(Main.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException("初始化配置失败");
        }
        //加载配置类中写明的实现类
        for (Map.Entry<Object, Object> entry: properties.entrySet()) {
            String beanName = entry.getKey().toString();
            try {
                Class<?> clazz = Class.forName(entry.getValue().toString());
                Object instance = clazz.getConstructor().newInstance();
                INSTANCE_POOL_MAP.put(beanName, instance);
            } catch (Exception e) {
                throw new RuntimeException("实现类的实例化失败");
            }
        }
    }

    // 私有化构造方法
    private ObjectFactory() {}
    
    public static <T> T getInstance(String className, Class<T> returnType) {
        return (T) INSTANCE_POOL_MAP.get(className);
    }
}
