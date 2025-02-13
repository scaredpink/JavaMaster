package i.love.wsq.service.impl;

import i.love.wsq.service.IMessageService;
import org.springframework.stereotype.Service;

/**
 * @author baitao05
 */
@Service
public class MessageService implements IMessageService {
    @Override
    public String echo(String str) {
        return "[echo]" + str;
    }
}
