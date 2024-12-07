package com.luv2code.springdemo.mvc.validationdemo.controller;

import com.luv2code.springdemo.mvc.validationdemo.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model theModel){

        theModel.addAttribute("customer", new Customer());

        return "customer-form";

    }

    @PostMapping("/processForm")
    public String process(@Valid @ModelAttribute("customer") Customer theCustomer,
                          BindingResult theBindingResult ){
        //validation results are stored in binding result. You may need to place it just after model parameter

        if(theBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "customer-confirmation";

        }
    }

}
