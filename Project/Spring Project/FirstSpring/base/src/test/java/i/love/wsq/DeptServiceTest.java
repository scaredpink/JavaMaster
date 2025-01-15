package i.love.wsq;

import i.love.wsq.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author baitao05
 */
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"}) // 定义xml配置文件
@RunWith(SpringRunner.class) // 使用测试工具JUnit
public class DeptServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeptServiceTest.class);

    @Autowired
    private IDeptService deptService;

    @Test
    public void testGet() {
        this.deptService.get(1L);

        LOGGER.info("[测试IDeptService.get]result: {}", this.deptService.get(123L));
    }
}
