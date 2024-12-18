package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController (EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployee(Model theModel){

        // get the employees from db
        List<Employee> employeeList = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", employeeList);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel){
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        employeeService.save(theEmployee);

        return "redirect:/employees/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("employeeId") int id,  Model theModel){
        Employee theEmployee = employeeService.findById(id);

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/delete") //Normalde derste burada get mapping kullanildi ancak get mapping islemlerinde herhangi bir yan etki olmamasi gerektigi icin list-employees formu
    //yeniden DUZENLENMEDI FYI
    public String deleteEmployee(@RequestParam("employeeId") int id){

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
