package com.i.love.wsq;

import java.util.concurrent.Callable;

/**
 * @author baitao05
 */
public class RunnableAdapter implements Runnable {
    //源接口
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException("接口转换异常");
        }
    }
}
