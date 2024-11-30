package com.luv2code.demo.rest;

import com.luv2code.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hi world";
    }

    @GetMapping("/user")
    public String test(){
        User test = new User(12, "hi" , "test");
        return test.toString();
    }
}




