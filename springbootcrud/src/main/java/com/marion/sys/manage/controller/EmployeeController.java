package com.marion.sys.manage.controller;

import com.marion.sys.manage.dao.DepartmentDao;
import com.marion.sys.manage.dao.EmployeeDao;
import com.marion.sys.manage.entities.Department;
import com.marion.sys.manage.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Collection;


@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }

    /**
     * 显示部门名称
     * @param model
     * @return
     */
    @GetMapping("/addlist")
    public String addlist(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return"listadd";
    }

    @PostMapping("/save")
    public String save(Employee employee){
        employeeDao.save(employee);
        return "redirect:/list";
    }

}
