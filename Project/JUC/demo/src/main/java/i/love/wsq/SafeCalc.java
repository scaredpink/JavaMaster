package i.love.wsq;

public class SafeCalc {
    Long value = 0L;
    Long get() {
        return this.value;
    }

    synchronized  void addOne() {
        value++;
    }
}
