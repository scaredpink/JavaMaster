package i.love.wsq.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author baitao05
 */

@ContextConfiguration(locations = {"classpath:spring/spring-ioc.xml"})
@RunWith(SpringRunner.class)
public class IMessageServiceTest {
    public static Logger LOGGER = LoggerFactory.getLogger(IMessageServiceTest.class);

    @Autowired
    private IMessageService messageService;

    @Test
    public void echoTest() {
        LOGGER.info("测试IMessageService.echo()");
        messageService.echo("测试消息服务接口成功");
    }
}
