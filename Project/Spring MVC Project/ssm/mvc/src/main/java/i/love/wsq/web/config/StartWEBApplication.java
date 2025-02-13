package i.love.wsq.web.config;

import i.love.wsq.context.config.SpringApplicationContextConfig;
import i.love.wsq.context.config.SpringWEBContextConfig;
import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author baitao05
 */
public class StartWEBApplication extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {   // 获取spring容器启动类
        return new Class[] {SpringApplicationContextConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { //SpringWeb容器启动类
        return new Class[] {SpringWEBContextConfig.class};
    }

    @Override
    protected String[] getServletMappings() {   // Dispatcher分发处理
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {    // 配置过滤器
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8"); // 编码设置
        encodingFilter.setForceEncoding(true); // 强制编码
        return new Filter[] {encodingFilter};
    }
}
