package i.love.wsq;

import i.love.wsq.duck.Duck;
import i.love.wsq.duck.MallardDuck;
import i.love.wsq.flybehaviour.impl.FlyNoWay;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        System.out.println("中箭了");
        mallard.setFlyBehaviour(new FlyNoWay());
        mallard.performFly();
    }
}
