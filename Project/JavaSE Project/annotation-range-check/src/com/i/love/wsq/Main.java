package com.i.love.wsq;

import com.i.love.wsq.Person;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Bob", "Beijing", 20);
        Person p2 = new Person("", "Shanghai", 20);
        Person p3 = new Person("Alice", "Shanghai", 199);
        for (Person p : new Person[] { p1, p2, p3 }) {
            try {
                check(p);
                System.out.println("Person " + p + " checked ok.");
            } catch (IllegalArgumentException | ReflectiveOperationException e) {
                System.out.println("Person " + p + " checked failed: " + e);
            }
        }
    }

    public static void check(Person p) throws IllegalArgumentException, ReflectiveOperationException{
        // 逐字段获取
        for (Field field : p.getClass().getDeclaredFields()) {
            // 修改访问权限，字段原本是private
            field.setAccessible(true);
            // 获取注解
            Range range = field.getAnnotation(Range.class);
            if (Objects.nonNull(range)) {
                Object value = field.get(p);
                if (value instanceof String) {
                    if (range.min() > ((String) value).length() || range.max() < ((String) value).length()) {
                        throw new IllegalArgumentException("字段长度不合规范");
                    }
                }
            }
        }
    }


}
