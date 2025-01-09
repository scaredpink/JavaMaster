package i.love.wsq.di.config;

import java.beans.ConstructorProperties;

/**
 * @author baitao05
 */
public class MessageConfig {    //定义消息数据的配置类
    private String host;
    private int port;
    private boolean enable;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "MessageConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", enable=" + enable +
                '}';
    }
}
