package i.love.wsq.duck;

import i.love.wsq.duck.Duck;
import i.love.wsq.flybehaviour.impl.FlyNoWay;
import i.love.wsq.quackbehaviour.impl.Squeak;

/**
 * @author baitao05
 */
public class RubberDuck extends Duck {
    public RubberDuck(){
        this.quackBehaviour = new Squeak();
        this.flyBehaviour = new FlyNoWay();
    }
    @Override
    public void display() {
        System.out.println("外表是橡皮鸭");
    }
}
