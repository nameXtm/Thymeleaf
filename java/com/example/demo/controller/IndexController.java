package com.example.demo.controller;

import com.example.demo.bean.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import java.lang.reflect.Method;

@Controller
public class IndexController {


    /**
     * 来登录页
     * @return
     */
    @GetMapping("/")
    public String loginPage(){
        return "login";
    }


    /**
     * 首页面
     * @param
     * @return
     */
    @PostMapping("/login")
    public  String main(User user , HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUserName()) && "123".equals(user.getPassword())){
            //把登录成功用户保存到session作用域中

            session.setAttribute("loginUser" , user);

            //登陆成功从定向到main.html页面下
            //重定向是解决页面重复提交的最好方式
            return  "redirect:/main.html";
        }else {
            model.addAttribute("msg" ,"账号或密码错误");
            return "login";
        }
    }

    /**
     * 去mian页面
     * @return
     */
    @GetMapping("/main.html")
    public String maiPage(HttpSession session ,Model model){
        //是否登录。 拦截器 过滤器
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        }else {
            model.addAttribute("msg" ,"请重新登录");
            return "login";
        }
    }

}
