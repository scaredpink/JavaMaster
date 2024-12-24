package i.love.wsq.flybehaviour.impl;

import i.love.wsq.flybehaviour.FlyBehaviour;

/**
 * @author baitao05
 */
public class FlyNoWay implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("不会飞捏");
    }
}
