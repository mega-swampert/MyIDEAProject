package com.spring.service;

import ch.qos.logback.core.boolex.EvaluationException;
import com.spring.bean.Employee;
import com.spring.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    //    将运行结果进行缓存
    @Cacheable(cacheNames = "emp"/*,keyGenerator = "myKeyGenerator",condition = "#id>1"*/)
    public Employee getEmpById(Integer id) {
        System.out.println("查询" + id + "号员工");
        Employee empById = employeeMapper.getEmpById(id);
        return empById;

    }

    /**
     * @CachePut：调用方法又更新缓存数据 运行先调用目标方法，将结果存入缓存
     */
    @CachePut(key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("更新：" + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict：缓存清除
     */
    @CacheEvict(key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("清除缓存" + id);
//        employeeMapper.deleteEmp(id);
    }

    /**
     *
     */
    @Caching(
            cacheable = {
                    @Cacheable(key = "#lastName")
            },
            put = {
                    @CachePut(key = "#result.id"),
                    @CachePut(key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }
}
