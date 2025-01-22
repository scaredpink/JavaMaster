package i.love.wsq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author baitao05
 */
public class  StartSpringApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(StartSpringApplication.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-base.xml");
    }
}
