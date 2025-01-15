package i.love.wsq;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author baitao05
 */
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"})
@RunWith(SpringRunner.class)
public class SpringProfileTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(SpringProfileTest.class);

    @Autowired
    private ApplicationContext context; // 注入上下文环境

    @Test
    public void testConfig() {
        LOGGER.info("{}", Arrays.toString(this.context.getEnvironment().getActiveProfiles()));
    }
}
