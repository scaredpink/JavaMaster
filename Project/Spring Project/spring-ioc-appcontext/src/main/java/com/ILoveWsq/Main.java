package com.ILoveWsq;

import com.ILoveWsq.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    private static final ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    private static final UserService userService = context.getBean(UserService.class);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你的想要完成的功能：");
        System.out.println("1:登录");
        System.out.println("2:注册");
        System.out.println("3:退出");
        while (scan.hasNext()) {
            String input = scan.nextLine();
            if (input.equals("1")) {
                System.out.println("请输入邮箱:");
                String email = scan.nextLine();
                System.out.println("请输入密码:");
                String password = scan.nextLine();
                userService.login(email, password);
            }
            if (input.equals("2")) {
                System.out.println("请输入邮箱:");
                String email = scan.nextLine();
                System.out.println("请输入密码:");
                String password = scan.nextLine();
                System.out.println("请输入昵称:");
                String name = scan.nextLine();
                userService.register(email, password, name);
            }
            if (input.equals("3")) {
                System.out.println("拜拜~");
                return;
            }
        }
    }
}
