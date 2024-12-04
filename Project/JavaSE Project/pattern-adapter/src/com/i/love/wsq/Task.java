package com.i.love.wsq;

import java.util.concurrent.Callable;

/**
 * @author baitao05
 */
public class Task implements Callable<Long> {

    private Long number;

    public Task(Long number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        Long r = 0L;
        for (Long i = 1L; i < this.number; i++) {
            r += i;
        }
        System.out.println("Result: " + r);
        return r;
    }
}
