package com.i.love.wsq.example2;

import java.math.BigDecimal;

/**
 * @author baitao05
 */
public class NumberFactory {
    static Number parse(String s) {
        return new BigDecimal(s);
    }
}
