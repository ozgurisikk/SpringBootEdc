package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // controller method to process the HTML form

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormTwo")
    public String shout(HttpServletRequest request, Model theModel){

        String name = request.getParameter("studentName");

        String result = "YO! " + name.toUpperCase();

        theModel.addAttribute("message", result);

        return "helloworld";
    }

}
