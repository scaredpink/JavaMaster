package i.love.wsq;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        Outer out = new Outer();
        out.out_printOuterName();
        out.out_printInnerName();
        out.getInner().in_printOuterName();
        out.getInner().in_printInnerName();

        Map

        Outer.Inner innerA = new Outer().new Inner();
    }
}