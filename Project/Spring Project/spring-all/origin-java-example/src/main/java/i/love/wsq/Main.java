package i.love.wsq;

import i.love.wsq.service.IMessageService;
import i.love.wsq.service.impl.QQMessageServiceImpl;

public class Main {
    public static void main(String[] args) {
        IMessageService messageService = new QQMessageServiceImpl();
        messageService.echo("灵感菇🐧🌹");
    }
}
