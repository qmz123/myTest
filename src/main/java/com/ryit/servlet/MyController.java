package com.ryit.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/12/28.
 */
@Controller
@RequestMapping("/")
public class MyController {

    @RequestMapping("hello")
    public String insert(){
        System.out.println("访问成功   ");
        return "/WEB-INF/qmz.jsp";
    }

}