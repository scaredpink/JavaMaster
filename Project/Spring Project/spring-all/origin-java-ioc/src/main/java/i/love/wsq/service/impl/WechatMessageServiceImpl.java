package i.love.wsq.service.impl;

import i.love.wsq.service.IMessageService;

public class WechatMessageServiceImpl implements IMessageService {
    @Override
    public void echo(String message) {
        System.out.println("【微信服务】" + message);
    }
}
