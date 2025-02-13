package i.love.wsq.action;

import i.love.wsq.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author baitao05
 */
@Controller
public class ContextAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContextAction.class);
    @Autowired
    private WebApplicationContext webApplicationContext; // WEB容器
    @Autowired
    private IMessageService messageService; // 业务接口实例
    @RequestMapping("/pages/context/show") // 映射地址
    public String show() {
        LOGGER.info("[子容器] ID:{}, NAME:{}", this.webApplicationContext.getId(), this.webApplicationContext.getApplicationName());
        LOGGER.info("[父容器] ID:{}, NAME:{}", this.webApplicationContext.getParent().getId(), this.webApplicationContext.getParent().getApplicationName());
        return null;
    }
}
