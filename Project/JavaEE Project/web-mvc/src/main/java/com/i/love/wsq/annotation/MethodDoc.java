package com.i.love.wsq.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author baitao05
 */
@Target(ElementType.METHOD)
public @interface MethodDoc {
    String description() default "";
}
