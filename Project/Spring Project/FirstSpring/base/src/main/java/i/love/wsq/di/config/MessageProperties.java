package i.love.wsq.di.config;

import java.util.Properties;

/**
 * @author baitao05
 */
public class MessageProperties { // 定义资源属性配置
    private String subject; // 操作主题
    // 一般的属性都是字符串的配置，例如，在后续使用到数据库的时候基本上都是字符串的资源
    private Properties attribute;   //定义属性

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Properties getAttribute() {
        return attribute;
    }

    public void setAttribute(Properties attribute) {
        this.attribute = attribute;
    }
}
