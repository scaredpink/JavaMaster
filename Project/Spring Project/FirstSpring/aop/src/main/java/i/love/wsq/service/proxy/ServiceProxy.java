package i.love.wsq.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author baitao05
 */
public class ServiceProxy implements InvocationHandler {
    private Object target; // 保存真实对象
    public Object bind (Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 需要判断当前的操作方法之中是否需要进行代理控制
        return null;
    }
}
