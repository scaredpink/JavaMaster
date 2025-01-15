package i.love.wsq.config;

import i.love.wsq.di.config.MessageConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author baitao05
 */

@Configuration
@Profile("dev") //当前为dev开发环境
public class DevMessageConfig {
    @Bean("messageConfig") //Bean的名称自定义
    public MessageConfig devMessageConfig() {
        MessageConfig config = new MessageConfig();
        config.setHost("dev.com");
        config.setPort(6657);
        config.setEnable(true);
        return config;
    }
}
