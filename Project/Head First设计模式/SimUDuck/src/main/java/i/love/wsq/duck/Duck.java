package i.love.wsq.duck;

import i.love.wsq.flybehaviour.FlyBehaviour;
import i.love.wsq.quackbehaviour.QuackBehaviour;

/**
 * @author baitao05
 */
public abstract class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;
    public void performQuack() {
        quackBehaviour.quack();
    }
    public void swim() {
        System.out.println("游呀游呀");
    }
    public abstract void display(); //每个鸭子长得不一样，所以是抽象方法

    public void performFly() {
        flyBehaviour.fly();
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}
