package com.i.love.wsq.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baitao05
 */
public class ModelAndView {
    public String view;
    public Map<String, Object> model;
    public ModelAndView(String view) {
        this.view = view;
        this.model = new HashMap<>();
    }

    public ModelAndView(Map<String, Object> model) {
        this.view = "";
        this.model = model;
    }

    public ModelAndView(String view, Map<String, Object> model) {
        this.model = model;
        this.view = view;
    }

    public ModelAndView(String view, String name, Object value) {
        this.view = view;
        this.model = new HashMap<>();
        this.model.put(name, value);
    }
}
