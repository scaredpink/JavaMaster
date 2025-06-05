package i.love.wsq;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Outer {
    private String name = "outer";
    private Inner inner = new Inner();
    // 外部类访问内部类属性
    public void out_printInnerName() {
        log.info("[Outer.out_printInnerName] inner.name={}", inner.name);
    }
    // 外部类访问内部类方法
    public void out_printOuterName() {
        System.out.println();
        log.info("[Outer.out_printOuterName] ----------start----------");
        inner.in_printOuterName();
        log.info("[Outer.out_printOuterName] -----------end-----------");
        System.out.println();
    }



    class Inner {
        private String name = "inner";
        // 内部类访问外部类属性
        public void in_printOuterName() {
            log.info("[Inner.in_printOuterName] outer.name={}", Outer.this.name);
        }
        // 内部类访问外部类方法
        public void in_printInnerName() {
            System.out.println();
            log.info("[Inner.in_printOuterName] ----------start----------");
            Outer.this.out_printInnerName();
            log.info("[Inner.in_printOuterName] -----------end-----------");
            System.out.println();
        }
    }
}
