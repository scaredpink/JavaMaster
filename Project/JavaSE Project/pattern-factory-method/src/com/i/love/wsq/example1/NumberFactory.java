package com.i.love.wsq.example1;

/**
 * @author baitao05
 */
public interface NumberFactory {
    Number parse(String s);

    static NumberFactory impl = new NumberFactoryImpl();
    static NumberFactory getFactory() {
        return impl;
    }
}
