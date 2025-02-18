package i.love.wsq.action;

import i.love.wsq.action.abs.AbstractAction;
import i.love.wsq.service.IMessageService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author baitao05
 */
@Controller // 控制层注解
@RequestMapping("/pages/message")
public class MessageAction extends AbstractAction {
    private static Logger LOGGER = LoggerFactory.getLogger(MessageAction.class);

    @Autowired
    private IMessageService messageService;     // 注入实例

    @GetMapping("/input")
    public String input() {
        return "/pages/message/input.jsp";
    }

    @PostMapping(value = "/echo")
    public ModelAndView echo(String message, Integer level, Date pubDate) {
        ModelAndView modelAndView = new ModelAndView("/pages/message/show.jsp");
        modelAndView.addObject("msg", message);
        modelAndView.addObject("level", level);
        modelAndView.addObject("pubDate", pubDate);
        return modelAndView;
    }
}
