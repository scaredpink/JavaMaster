package i.love.wsq.config;

import i.love.wsq.di.config.MessageConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author baitao05
 */
@Configuration
@Profile("prod")
public class ProdMessageConfig {
    @Bean("messageConfig") //Bean的名称自定义
    public MessageConfig testMessageConfig() {
        MessageConfig config = new MessageConfig();
        config.setHost("prod.com");
        config.setPort(1234);
        config.setEnable(true);
        return config;
    }
}
