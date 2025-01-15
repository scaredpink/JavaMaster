package i.love.wsq;

import i.love.wsq.di.config.MessageConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author baitao05
 */
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"})
@RunWith(SpringRunner.class)
@ActiveProfiles("test") // 设置profile信息
public class MessageConfigTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceTest.class);

    @Autowired
    private MessageConfig config;

    @Test
    public void testConfig() {
        LOGGER.info(config.toString());
    }
}
