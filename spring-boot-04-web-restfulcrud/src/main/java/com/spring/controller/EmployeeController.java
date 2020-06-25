package com.spring.controller;


import com.spring.dao.DepartmentDao;
import com.spring.dao.EmployeeDao;
import com.spring.entities.Department;
import com.spring.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    //注入employeedao
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;


    //查询员工列表，以get请求的方式
    @GetMapping("/emps")//映射emps路径
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //将emp放进请求域中共享
        model.addAttribute("emps", employees);
        //thymeleaf默认拼串"classpath:/templates/xxx.html"
        return "emp/list";
    }

    //转到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //到添加页面后，查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //员工添加功能
    //springmvc自动将请求参数和入参对象的属性进行绑定，要求请求参数的名字和javabean入参对象里面的属性名一致
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //来到员工列表 redirect重定向到地址 forward转发到地址
        System.out.println("保存" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";

    }

    @GetMapping("/emp/{id}")//到修改页面
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //显示所有列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面
        return "emp/add";
    }

    //员工修改功能，需要提交员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
