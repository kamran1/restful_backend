package com.example.sample.persistance.service;

import com.example.sample.persistance.model.Department;
import com.example.sample.persistance.model.Employee;

import java.util.Map;

/**
 * Created by Kamran Majeed on 5/16/2021.
 */
public interface IEmployeeService {

    Employee createEmployees(Employee employee);
    Map<String, Object> getEmployees(String page,
                                       String limit,
                                       String sort);
    Iterable<Department> getDepartments();

}
