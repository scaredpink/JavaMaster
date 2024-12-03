package com.i.love.wsq.bean;

import com.i.love.wsq.bean.School;

/**
 * @author baitao05
 */
public class User {
    public long id;
    public String name;
    public School school;

    public User(long id, String name, School school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }
}
