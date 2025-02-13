package i.love.wsq.context.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author baitao05
 */
@Configuration
@ComponentScan({"i.love.wsq.service", "i.love.wsq.config", "i.love.wsq.dao"})
public class SpringApplicationContextConfig {
}
