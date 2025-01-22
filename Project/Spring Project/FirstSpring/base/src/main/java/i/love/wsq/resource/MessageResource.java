package i.love.wsq.resource;

import org.springframework.core.io.Resource;

/**
 * @author baitao05
 */
public class MessageResource {  // 消息资源读取
    private Resource[] resource;  // 配置资源实例

    public Resource[] getResource() {
        return resource;
    }

    public void setResource(Resource[] resource) {
        this.resource = resource;
    }
}
