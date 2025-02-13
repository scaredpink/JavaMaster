package i.love.wsq.service;

import i.love.wsq.config.MessageConfig;
import i.love.wsq.status.MessageSendStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageService implements AutoCloseable{
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
    private MessageConfig messageConfig;

    public boolean connect() {
        LOGGER.info("消息服务连接成功");
        return true;
    }

    public MessageSendStatus sendMessage(String message) {
        try {
            if (this.connect()) {
                LOGGER.info("发送消息内容: {}", messageConfig + " " + message);
                return MessageSendStatus.SUCCESS;
            }
        } catch (Exception e) {
            LOGGER.error("发送消息失败");
            return MessageSendStatus.FAILURE;
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("断开连接");
    }

    public MessageConfig getMessageConfig() {
        return messageConfig;
    }

    public void setMessageConfig(MessageConfig messageConfig) {
        this.messageConfig = messageConfig;
    }
}
