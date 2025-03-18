package i.love.wsq;

import i.love.wsq.service.IMessageService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baitao05
 */
@Service
public class MessageManager {
    @Autowired
    private Map<String, IMessageService> messageServiceMap;

    public void print() {
        System.out.println(this.messageServiceMap);
    }
}
