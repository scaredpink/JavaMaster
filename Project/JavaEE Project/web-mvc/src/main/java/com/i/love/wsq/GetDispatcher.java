package com.i.love.wsq;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author baitao05
 */
public class GetDispatcher {
    Object instance;                // Controller实例
    Method method;                  // Controller方法
    String[] parameterNames;        // 方法参数名称
    Class<?>[] parameterClasses;    // 方法参数类型

    public ModelAndView invoke(HttpServletRequest req, HttpServletResponse resp) {

    }
}
