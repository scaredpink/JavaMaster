package i.love.wsq.quackbehaviour.impl;

import i.love.wsq.quackbehaviour.QuackBehaviour;

/**
 * @author baitao05
 */
public class MuteQuack implements QuackBehaviour {
    @Override
    public void quack() {
        // 不会叫
        System.out.println("<< 没有声音 >>");
    }
}
