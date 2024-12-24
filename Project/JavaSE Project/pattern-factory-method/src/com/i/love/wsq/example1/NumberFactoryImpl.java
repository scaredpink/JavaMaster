package com.i.love.wsq.example1;

import java.math.BigDecimal;

/**
 * @author baitao05
 */
public class NumberFactoryImpl implements NumberFactory {
    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
