package i.love.wsq.quackbehaviour.impl;

import i.love.wsq.quackbehaviour.QuackBehaviour;

/**
 * @author baitao05
 */
public class Quack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}
