package i.love.wsq.action;

import i.love.wsq.service.IMessageService;
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
public class MessageAction {
    private static Logger LOGGER = LoggerFactory.getLogger(MessageAction.class);

    @Autowired
    private IMessageService messageService;     // 注入实例

    @GetMapping(value = "/echo_map/{.*}")
    public ModelAndView echo(
            @MatrixVariable Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            LOGGER.info("消息回应处理 {} = {}", entry.getKey(), entry.getValue());
        }
        return null;
    }
}
