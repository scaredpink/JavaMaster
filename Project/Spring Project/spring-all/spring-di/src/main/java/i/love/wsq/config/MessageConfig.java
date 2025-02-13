package i.love.wsq.config;

public class MessageConfig {
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
        return  "host='" + host + '\'' +
                ", port=" + port +
                ", enable=" + enable +
                '}';
    }
}
