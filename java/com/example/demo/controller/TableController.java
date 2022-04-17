package com.example.demo.controller;

import com.example.demo.bean.User;
import jdk.jfr.Registered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping("dynamic_table")
    public String dynamic_table(Model model){
        //把表格的内容是动态遍历
        List<User> users01 = Arrays.asList(new User("zhang", "123456"),
                new User("zhang", "123456"),
                new User("x", "123456"),
                new User("t", "123456"),
                new User("m", "123456"));
        model.addAttribute("users01" ,users01);

        return "table/dynamic_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("editable_table")
    public String editable_table(){
        return "table/editable_table";
    }


}
