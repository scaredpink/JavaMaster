package i.love.wsq.di.service;

import i.love.wsq.di.config.MessageConfig;
import i.love.wsq.di.type.MessageSendStatus;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author baitao05
 */
@Service
public class MessageService implements AutoCloseable {   // 消息的服务处理
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
    private Map<String, MessageConfig> messageConfigs;   // 这个类的执行需要config属性支持
    private MessageConfig currentConfig;
    private String currentKey;

    private boolean connect() { // 连接服务器方法（模拟）
        LOGGER.info("[{}]{}:{}", this.currentKey, this.currentConfig.getHost(), this.currentConfig.getPort());
        return this.currentConfig.isEnable(); // 通过enable状态决定是否连接成功
    }

    public MessageSendStatus send(String msg) { // 消息发送
        try {
            Iterator<Map.Entry<String, MessageConfig>> iterator = this.messageConfigs.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, MessageConfig> entry = iterator.next(); // 广播所有的消息
                this.currentConfig = entry.getValue();
                this.currentKey = entry.getKey();
                if (this.connect()) {
                    LOGGER.debug("[消息发送]{}", msg);
                    this.close();
                } else {
                    LOGGER.error("消息发送失败，无法连接");
                }
            }
            return MessageSendStatus.SUCCESS;
        } catch (Exception e) {
            LOGGER.error("[消息发送异常]: {}", e.getMessage());
            return MessageSendStatus.FAILURE;
        }
    }

    public Map<String, MessageConfig> getMessageConfigs() {
        return this.messageConfigs;
    }

    // 此时该Bean（注册完成的类对象），中的config属性需要通过配置文件定义注入管理
    public void setMessageConfigs(Map<String, MessageConfig> messageConfigs) {   // 外部注入config实例
        LOGGER.debug("[设置MessageConfig依赖关联]setConfig方法");
        this.messageConfigs = messageConfigs;
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("[消息发送完毕]断开消息发送通道");
    }
}
