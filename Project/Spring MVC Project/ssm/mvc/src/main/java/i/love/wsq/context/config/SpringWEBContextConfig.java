package i.love.wsq.context.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author baitao05
 */
@Configuration
@EnableWebMvc // 加入此注解才表示WEBMVC配置类有效
@ComponentScan({"i.love.wsq.action"})
public class SpringWEBContextConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) { // 矩阵参数的配置
        UrlPathHelper urlPathHelper = new UrlPathHelper(); // 配置一个对象
        urlPathHelper.setRemoveSemicolonContent(false); // 启用矩阵参数接收
        configurer.setUrlPathHelper(urlPathHelper); // 配置路径参数
    }
}
