package com.vsl700.employeemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vsl700.employeemanagement.data.models.Employee;
import com.vsl700.employeemanagement.services.EmployeeService;

@Controller /* ("customers") */
public class EmployeeController {
    
	@Autowired
	private EmployeeService employeeService;
	
    @GetMapping("/customers")
    public String customersTable(){
        return "redirect:/customers/1";
    }

    @GetMapping("/customers/{page}")
    public String customersTable(@PathVariable int page, @RequestParam(required = false, defaultValue = "") String sort, Model model){
        if(page < 1)
            return "redirect:/customers/1";

        int pages = employeeService.getViewPagesAmount();
        if(page > pages)
            return "redirect:/customers/" + pages;

    	model.addAttribute("empList", employeeService.getAllEmployees(page, sort));
        model.addAttribute("page", page);
        model.addAttribute("pages", pages);
        // if(!sort.equals(""))
        //     model.addAttribute("sort", sort);
        
        return "customers";
    }

    @GetMapping("/customers/addEmployee")
    public String createEmployee(){
        return "addEmployee";
    }

    @PostMapping("/customers/addEmployee")
    public String createEmployee(Employee employee){
        employeeService.save(employee);
        return "redirect:/customers";
    }

    @GetMapping("/customers/updateEmployee/{id}")
    public String updateEmployeeView(@PathVariable String id, Model model){
        model.addAttribute("employee", employeeService.getById(id));
        return "updateEmp";
    }

    @PostMapping("/customers/updateEmployee/{id}")
    public String updateEmployee(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/customers";
    }

    @GetMapping("/customers/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable String id){
        employeeService.deleteById(id);
        return "redirect:/customers";
    }
}
