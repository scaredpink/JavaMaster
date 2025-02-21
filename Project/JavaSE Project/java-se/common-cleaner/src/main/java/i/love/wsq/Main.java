package i.love.wsq;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jdk.nashorn.internal.runtime.options.Option;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            String message = "A发送的消息";
            NetConnection conn = NetResourceFactory.getNetConnection("用户A");
            conn.send(message);
        }).start();

        new Thread(() -> {
            String message = "B发送的消息";
            NetConnection conn = NetResourceFactory.getNetConnection("用户B");
            conn.send(message);
        }).start();
    }
}

class NetResourceFactory {
    public static final ThreadLocal<NetConnection> NET_CONNECTION_THREAD_LOCAL = new ThreadLocal<>();

    public static NetConnection getNetConnection(String userInfo) {
        NetConnection conn = NET_CONNECTION_THREAD_LOCAL.get();
        if (conn == null) {
            conn = new NetConnection();
            conn.setUserInfo(userInfo);
            NET_CONNECTION_THREAD_LOCAL.set(conn);
        }
        return conn;
    }
}

class NetConnection {
    private String userInfo;
    public void send(String msg) {
        System.out.printf("NetConnection %s 发送: %s\n", this.userInfo, msg);
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
