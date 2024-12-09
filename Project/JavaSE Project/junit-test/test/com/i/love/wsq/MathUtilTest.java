package com.i.love.wsq;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao05
 */
public class MathUtilTest {
    @Test
    public void addTest() {
        Assert.assertEquals(10, MathUtil.add(1,2,3,4));
//        Assert.assertEquals(11, MathUtil.add(1,2,3,4));
    }
}
