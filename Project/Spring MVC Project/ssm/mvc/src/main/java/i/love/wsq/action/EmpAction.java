package i.love.wsq.action;

import com.sun.org.apache.xpath.internal.operations.Mod;
import i.love.wsq.action.abs.AbstractAction;
import i.love.wsq.vo.Emp;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author baitao05
 */
@Controller
@RequestMapping("/pages/emp")
public class EmpAction extends AbstractAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpAction.class);

    @RequestMapping("/add")
    public ModelAndView add(@RequestBody List<Emp> empList) { // 接收一组雇员信息
        // @RequestBody的目的就是告诉控制层，此时传输的是JSON数据
        // 需要通过Jackson来转换
        for (Emp emp : empList) {
            LOGGER.info("入参: {}", emp);
        }
        return null;
    }
}
