package i.love.wsq;

import i.love.wsq.di.config.MessageConfig;
import i.love.wsq.di.config.MessageProperties;
import i.love.wsq.di.service.MessageService;
import i.love.wsq.service.IMessageService;
import i.love.wsq.vo.Dept;
import i.love.wsq.vo.Emp;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baitao05
 */
public class  StartSpringApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(StartSpringApplication.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-base.xml");
        MessageProperties messageProperties = context.getBean(MessageProperties.class);
        LOGGER.info("[{}]属性配置: {}", messageProperties.getSubject(), messageProperties.getAttribute());
    }
}
