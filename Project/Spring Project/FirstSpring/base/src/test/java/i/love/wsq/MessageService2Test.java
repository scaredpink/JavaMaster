package i.love.wsq;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author baitao05
 */
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"}) //进行Spring配置文件的加载，后续也可能是进行配置类的加载
@RunWith(SpringRunner.class)
public class MessageService2Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceTest.class);

}