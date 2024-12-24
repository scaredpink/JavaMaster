package i.love.wsq.quackbehaviour.impl;

import i.love.wsq.quackbehaviour.QuackBehaviour;

/**
 * @author baitao05
 */
public class Squeak implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("挤压出的呱呱声");
    }
}
