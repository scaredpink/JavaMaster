package i.love.wsq.duck;

import i.love.wsq.duck.Duck;
import i.love.wsq.flybehaviour.impl.FlyWithWings;
import i.love.wsq.quackbehaviour.impl.Quack;

/**
 * @author baitao05
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("外表是绿头鸭");
    }
}
