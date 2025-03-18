package i.love.wsq;

import i.love.wsq.service.MessageManager;
import i.love.wsq.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(locations = {"classpath:spring/spring-di.xml"})
@RunWith(SpringRunner.class)
public class MessageServiceTest {
    private static Logger LOGGER = LoggerFactory.getLogger(MessageServiceTest.class);
    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageManager messageManager;

    @Test
    public void SendMessageTest() {
        LOGGER.debug("测试消息服务");
        messageService.sendMessage("Hello DI");
    }

    @Test
    public void testManager() {
        messageManager.print();
    }
}
