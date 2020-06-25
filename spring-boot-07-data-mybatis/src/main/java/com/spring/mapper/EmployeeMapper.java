package com.spring.mapper;


import com.spring.bean.Employee;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

}
