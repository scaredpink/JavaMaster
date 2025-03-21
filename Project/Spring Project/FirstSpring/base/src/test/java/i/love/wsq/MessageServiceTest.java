package i.love.wsq;

import i.love.wsq.di.service.MessageService;
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
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"}) //进行Spring配置文件的加载，后续也可能是进行配置类的加载
@RunWith(SpringRunner.class)
public class MessageServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceTest.class);

    @Autowired  // 自动注入接口实例
    private MessageService messageService; //要使用的业务接口
    @Test
    public void testEcho() {
        messageService.send("测试");
    }
}
