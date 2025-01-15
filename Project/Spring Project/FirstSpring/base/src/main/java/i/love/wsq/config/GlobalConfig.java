package i.love.wsq.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author baitao05
 */
@Configuration
@ComponentScan({"i.love.wsq.service", "i.love.wsq.dao"})
public class GlobalConfig { //全局配置类

}
