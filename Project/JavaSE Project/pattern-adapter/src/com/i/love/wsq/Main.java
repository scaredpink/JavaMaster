package com.i.love.wsq;

import com.i.love.wsq.Task;
import java.util.concurrent.Callable;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        Callable<?> callable = new Task(20010918L);
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();
    }
}
