package i.love.wsq.reource;

import i.love.wsq.resource.MessageResource;
import java.io.IOException;
import java.util.Scanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author baitao05
 */

@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"})
@RunWith(SpringRunner.class)
public class MessageResourceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageResourceTest.class);
    @Autowired
    private MessageResource messageResource;
    @Test
    public void testResource() throws IOException {
        for (Resource resource : this.messageResource.getResource()) {
            LOGGER.info("资源路径: {}", resource);
        }

    }
}
