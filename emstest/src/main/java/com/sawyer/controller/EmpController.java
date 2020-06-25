package com.sawyer.controller;

import com.sawyer.entity.Emp;
import com.sawyer.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/emp")
public class EmpController {

    @Autowired
    EmpService empService;


    @PostMapping(value = "/update")
    public String update(Emp emp){
        empService.update(emp);
        return "redirect:/emp/findAll";
    }


    @GetMapping(value = "/find")
    public String find(String id,Model model) {
        Emp emp = empService.find(id);
        model.addAttribute("emp" ,emp);
        return "ems/updateEmp";
    }

    @GetMapping(value = "/delete")
    public String delete(String id){
        empService.delete(id);
        return "redirect:/emp/findAll";
    }


    @PostMapping(value = "/save")
    public String save(Emp emp) {
        empService.save(emp);
        return "redirect:/emp/findAll";
    }


    @GetMapping(value = "/findAll")
    public String findAll(Model model) {
        List<Emp> emps = empService.findAll();
        model.addAttribute("emps", emps);
        return "ems/emplist";

    }
}
