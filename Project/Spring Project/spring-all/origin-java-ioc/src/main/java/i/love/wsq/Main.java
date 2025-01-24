package i.love.wsq;

import i.love.wsq.factory.ObjectFactory;
import i.love.wsq.service.IMessageService;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i ++ ) {
            int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    IMessageService messageService = ObjectFactory.getInstance(finalI % 2 == 0 ? "QQMessageService" : "WechatMessageService", IMessageService.class);
                    messageService.echo(Thread.currentThread() + " " + messageService.toString() + " " + (finalI % 2 == 0 ? "灵感菇🐧🌹" : "兔刀乐🐧🌹"));
                }
            });
            thread.start();
        }
    }
}
