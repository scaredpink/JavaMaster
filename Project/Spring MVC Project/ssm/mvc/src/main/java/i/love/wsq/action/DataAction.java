package i.love.wsq.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author baitao05
 */
@Controller
@RequestMapping("/pages/data")
public class DataAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataAction.class);

    @RequestMapping("/set_param")
    public String setParam(RedirectAttributes attributes) {
        attributes.addAttribute("name", "baitao");  // 属性设置
        attributes.addAttribute("url", "www.baidu.com");    // 属性设置
        return "redirect:/pages/data/list_param"; // 跳转到其他控制层方法
    }

    @RequestMapping("/list_param")
    public String listParam(String name, String url) {
        LOGGER.info("【Redirect参数接收】name = {}, url = {}", name, url);
        return "/pages/data/show.jsp";
    }

    @RequestMapping("/set_flash")
    public String setFlash(RedirectAttributes attributes) {
        attributes.addFlashAttribute("name", "baitao");  // 属性设置
        attributes.addFlashAttribute("url", "www.baidu.com");    // 属性设置
        return "redirect:/pages/data/list_flash"; // 跳转到其他控制层方法
    }
    @RequestMapping("/list_flash")
    public String listFlash(ModelMap map) {
        LOGGER.info("【Redirect参数接收】map = {}", map);
        return "/pages/data/show.jsp";
    }
}
