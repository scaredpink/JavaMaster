package com.i.love.wsq.framework;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.i.love.wsq.annotation.FieldDoc;
import com.i.love.wsq.annotation.MethodDoc;
import com.i.love.wsq.controller.IndexController;
import com.i.love.wsq.controller.UserController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author baitao05
 */
@WebServlet(urlPatterns = "/")
public class DispatcherServlet extends HttpServlet {

//    private final Logger logger = LoggerFactory.getLogger(getClass());
    private Map<String, GetDispatcher> getMappings = new HashMap<>();
    private Map<String, PostDispatcher> postMappings = new HashMap<>();
    private List<Class<?>> controllers = Arrays.asList(IndexController.class, UserController.class);

    @Override
    public void init() throws ServletException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 依次处理每个Controller:
        for (Class<?> controllerClass : controllers) {
            try {
                Object controllerInstance = controllerClass.getConstructor().newInstance();
                // 依次处理每个Method:
                for (Method method : controllerClass.getMethods()) {
                    if (method.getAnnotation(GetMapping.class) != null) {
                        // todo:校验入参是否合规
                        // 获得方法参数名称列表
                        String[] parameterNames = Arrays.stream(method.getParameters())
                                .map(Parameter::getName)
                                .toArray(String[]::new);
                        // 获得方法对应的请求路径
                        String path = method.getAnnotation(GetMapping.class).value();
                        this.getMappings.put(path, new GetDispatcher(controllerInstance, method, parameterNames, method.getParameterTypes()));

                    } else if (method.getAnnotation(PostMapping.class) != null) {
                        // todo:校验入参是否合规
                        String path = method.getAnnotation(PostMapping.class).value();
                        this.postMappings.put(path, new PostDispatcher(controllerInstance, method,
                                method.getParameterTypes(), objectMapper));
                    }
                }
            } catch (ReflectiveOperationException e) {
                throw new ServletException(e);
            }
        }
        //todo:创建ViewEngine
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String path = req.getRequestURI().substring(req.getContextPath().length());
        GetDispatcher dispatcher = this.getMappings.get(path);
        if (dispatcher == null) {
            resp.sendError(404);
            return;
        }

        ModelAndView modelAndView = null;
        try {
            modelAndView = dispatcher.invoke(req, resp);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        if (modelAndView == null) {
            return;
        }

        if (modelAndView.getView().startsWith("redirect:")) {
            resp.sendRedirect(modelAndView.getView().substring(9));
            return;
        }

        PrintWriter pw = resp.getWriter();
        this.viewEngine.render(modelAndView, pw);
        pw.flush();
    }

    public void process(HttpServletRequest req, HttpServletResponse rep, Map<String, >)
}


class GetDispatcher {
    @FieldDoc(description = "Controller实例")
    Object instance;
    @FieldDoc(description = "Controller方法")
    Method method;
    @FieldDoc(description = "方法参数名称")
    String[] parameterNames;
    @FieldDoc(description = "方法参数类型")
    Class<?>[] parameterClasses;

    public GetDispatcher(Object instance, Method method, String[] parameterNames, Class<?>[] parameterClasses) {
        this.instance = instance;
        this.method = method;
        this.parameterNames = parameterNames;
        this.parameterClasses = parameterClasses;
    }

    @MethodDoc(description = "处理请求")
    public ModelAndView invoke(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException {
        Object[] arguments = new Object[parameterClasses.length];
        for (int i = 0; i < parameterClasses.length; i ++ ) {
            String parameterName = parameterNames[i];
            Class<?> parameterClass = parameterClasses[i];
            if (parameterClass == HttpServletRequest.class) {
                arguments[i] = req;
            } else if (parameterClass == HttpServletResponse.class) {
                arguments[i] = resp;
            } else if (parameterClass == HttpSession.class) {
                arguments[i] = req.getSession();
            } else if (parameterClass == int.class) {
                arguments[i] = Integer.valueOf(getOrDefault(req, parameterName, "0"));
            } else if (parameterClass == long.class) {
                arguments[i] = Long.valueOf(getOrDefault(req, parameterName, "0"));
            } else if (parameterClass == boolean.class) {
                arguments[i] = Boolean.valueOf(getOrDefault(req, parameterName, "false"));
            } else if (parameterClass == String.class) {
                arguments[i] = getOrDefault(req, parameterName, "");
            } else {
                throw new RuntimeException("Missing handler for type: " + parameterClass);
            }
        }
        return (ModelAndView) this.method.invoke(this.instance, arguments);
    }

    private String getOrDefault(HttpServletRequest request, String name, String defaultValue) {
        String s = request.getParameter(name);
        return s == null ? defaultValue : s;
    }


}


class PostDispatcher {
    @FieldDoc(description = "Controller实例")
    Object instance;
    @FieldDoc(description = "Controller方法")
    Method method;
    @FieldDoc(description = "方法参数类型")
    Class<?>[] parameterClasses;
    @FieldDoc(description = "JSON格式参数body")
    ObjectMapper objectMapper;

    public PostDispatcher(Object instance, Method method, Class<?>[] parameterClasses, ObjectMapper objectMapper) {
        this.instance = instance;
        this.method = method;
        this.parameterClasses = parameterClasses;
        this.objectMapper = objectMapper;
    }

    public ModelAndView invoke(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        Object[] arguments = new Object[parameterClasses.length];
        for (int i = 0; i < parameterClasses.length; i ++ ) {
            Class<?> parameterClass = parameterClasses[i];
            if (parameterClass == HttpServletRequest.class) {
                arguments[i] = req;
            } else if (parameterClass == HttpServletResponse.class) {
                arguments[i] = resp;
            } else if (parameterClass == HttpSession.class) {
                arguments[i] = req.getSession();
            } else {
                // 读取JSON并解析为JavaBean:
                BufferedReader reader = req.getReader();
                arguments[i] = this.objectMapper.readValue(reader, parameterClass);
            }
        }
        return (ModelAndView) this.method.invoke(instance, arguments);
    }
}

