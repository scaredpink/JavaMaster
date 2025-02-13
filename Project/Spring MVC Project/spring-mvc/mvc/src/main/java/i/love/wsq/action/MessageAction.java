package i.love.wsq.action;

import i.love.wsq.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageAction.class);

    @Autowired
    private IMessageService messageService;

    @RequestMapping("/pages/message/echo")
    public ModelAndView echo(String msg) {
        LOGGER.info("消息回应处理 msg = {}", msg);
        // 控制器跳转到显示层进行数据展示，跳转路径及属性传递通过ModelAndView封装
        ModelAndView modelAndView = new ModelAndView("/pages/message/show.jsp");
        // 调用业务层处理方法，并将结果通过request属性范围传递到JSP页面上
        modelAndView.addObject("echoMessage", this.messageService.echo(msg)); // 业务处理
        return modelAndView;
    }
}
