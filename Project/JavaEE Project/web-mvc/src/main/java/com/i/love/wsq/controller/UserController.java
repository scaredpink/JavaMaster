package com.i.love.wsq.controller;

import com.i.love.wsq.framework.GetMapping;
import com.i.love.wsq.bean.User;
import com.i.love.wsq.framework.ModelAndView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author baitao05
 */
public class UserController {
    @GetMapping("/user/profile")
    public ModelAndView profile(HttpServletResponse response, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 未登录，跳转到登录页:
            return new ModelAndView("redirect:/signin");
        }
        if (!user.isManager()) {
            // 权限不够，返回403:
            response.sendError(403);
            return null;
        }
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        return new ModelAndView("/profile.html", model);
    }
}
