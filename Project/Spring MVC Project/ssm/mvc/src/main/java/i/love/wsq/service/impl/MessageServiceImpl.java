package i.love.wsq.service.impl;

import i.love.wsq.service.IMessageService;
import org.springframework.stereotype.Service;

/**
 * @author baitao05
 */
@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public String echo(String msg) {
        return "[ECHO]" + msg;
    }
}
