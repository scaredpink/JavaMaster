package i.love.wsq.service.impl;

import i.love.wsq.service.IMessageService;

/**
 * @author baitao05
 */
public class MessageServiceImpl implements IMessageService {
    @Override
    public String echo(String msg) {
        System.out.println(msg);
        return "[IMessageService.echo]" + msg;
    }
}
