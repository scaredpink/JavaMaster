package i.love.wsq.duck;

import i.love.wsq.duck.Duck;
import i.love.wsq.flybehaviour.impl.FlyWithWings;
import i.love.wsq.quackbehaviour.impl.Quack;
import java.lang.annotation.Retention;

/**
 * @author baitao05
 */
public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        this.quackBehaviour = new Quack();
        this.flyBehaviour = new FlyWithWings();
    }
    @Override
    public void display() {
        System.out.println("外表是红头鸭");
    }
}
