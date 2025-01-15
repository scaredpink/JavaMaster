package i.love.wsq.config;

import i.love.wsq.di.config.MessageConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author baitao05
 */
@Configuration
@Profile("test")
public class TestMessageConfig {
    @Bean("messageConfig") //Bean的名称自定义
    public MessageConfig testMessageConfig() {
        MessageConfig config = new MessageConfig();
        config.setHost("test.com");
        config.setPort(123321);
        config.setEnable(true);
        return config;
    }
}
