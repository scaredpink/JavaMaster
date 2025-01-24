package i.love.wsq;

import i.love.wsq.service.IMessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 加载项目中的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-ioc.xml");
        IMessageService messageService = context.getBean(IMessageService.class);
        messageService.echo("完成了Spring的控制反转");
    }
}
