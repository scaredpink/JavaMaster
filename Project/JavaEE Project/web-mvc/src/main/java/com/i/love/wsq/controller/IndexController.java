package com.i.love.wsq.controller;

import com.i.love.wsq.bean.User;
import com.i.love.wsq.framework.GetMapping;
import com.i.love.wsq.framework.ModelAndView;
import javax.servlet.http.HttpSession;

/**
 * @author baitao05
 */
public class IndexController {
    @GetMapping("/")
    public ModelAndView index(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return new ModelAndView("/index.html", "user", user);
    }

    @GetMapping("/hello")
    public ModelAndView hello(String name) {
        if (name == null) {
            name = "World";
        }
        return new ModelAndView("/hello.html", "name", name);
    }
}
