package i.love.wsq.action;

import i.love.wsq.service.IMessageService;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author baitao05
 */
@Controller // 控制层注解
@RequestMapping("/pages/message")
public class MessageAction {
    private static Logger LOGGER = LoggerFactory.getLogger(MessageAction.class);

    @Autowired
    private IMessageService messageService;     // 注入实例

    @GetMapping(value = "/echo")
    public ModelAndView echo(String msg) {

        LOGGER.info("消息回应处理 msg = {}", msg);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/pages/message/show.jsp");

        //构建信息
        Map<String, Object> result = new HashMap<>();
        result.put("echoMessage", this.messageService.echo(msg));
        result.put("id", "baitao05");
        result.put("edu", "bupt");

        // 保存信息
        modelAndView.addAllObjects(result);
        return modelAndView;
    }

    @PostMapping("/add")
    public String add() {
        return null;
    }

    @PostMapping("/edit")
    public String edit() {
        return null;
    }

    @PostMapping("/delete")
    public String delete() {
        return null;
    }

}
