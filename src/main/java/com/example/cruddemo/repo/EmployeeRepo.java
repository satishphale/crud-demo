package com.example.cruddemo.repo;

import com.example.cruddemo.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeRepo {

    @Select("select * from tacdb.employee")
    public List<Employee> findAll();

    @Select("SELECT * FROM tacdb.employee WHERE id = #{id}")
    public Optional<Employee> findEmployeeById(long id);

    @Delete("DELETE FROM tacdb.employee WHERE id = #{id}")
    public void deleteEmployeeById(long id);

    @Insert("INSERT INTO tacdb.employee(id, email,employeecode,imageurl,jobtitle,name,phone) VALUES (#{id}, #{email}, #{employeecode},#{imageurl},#{jobtitle},#{name},#{phone})")
    public int insert(Employee employee);

    @Update("Update tacdb.employee set email=#{email},employeecode=#{employeecode},imageurl=#{imageurl},jobtitle =#{jobtitle},name=#{name},phone=#{phone} where id=#{id}")
    public int update(Employee employee);


}
