package i.love.wsq.flybehaviour.impl;

import i.love.wsq.flybehaviour.FlyBehaviour;

/**
 * @author baitao05
 */
public class FlyWithWings implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("用翅膀飞呀飞呀");
    }
}
