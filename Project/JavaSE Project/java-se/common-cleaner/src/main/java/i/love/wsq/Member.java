package i.love.wsq;

/**
 * @author baitao05
 */
public class Member {
    public Member() {
        System.out.println("初始化时调用构造方法");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("结束时销毁");
        super.finalize();
    }
}
