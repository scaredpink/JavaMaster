package i.love.wsq.service.impl;

import i.love.wsq.service.IMessageService;
import org.springframework.stereotype.Service;

@Service
public class QQMessageServiceImpl implements IMessageService {
    @Override
    public void echo(String message) {
        System.out.println("【QQ服务】" + message);
    }
}
