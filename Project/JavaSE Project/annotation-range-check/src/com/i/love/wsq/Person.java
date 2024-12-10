package com.i.love.wsq;

/**
 * @author baitao05
 */
public class Person {
    @Range(min = 2, max = 20)
    private String name;
    @Range(min = 1, max = 100)
    private String city;
    private Integer age;

    public Person(String name, String city, Integer age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
