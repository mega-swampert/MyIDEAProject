package com.spring.mapper;

import com.spring.bean.Department;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

//@Mapper
//此处可以不写Mapper，在主程序中添加@MapperScan mapper路径
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    //    指定id为主键
//    若数据库使用驼峰命名，需要编写MybatisConfig
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
