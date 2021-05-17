package com.example.sample.persistance.service;

import com.example.sample.persistance.model.Department;
import com.example.sample.persistance.model.Employee;
import com.example.sample.persistance.repos.DepartmentRepo;
import com.example.sample.persistance.repos.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kamran Majeed on 5/16/2021.
 */

@Service
@Slf4j
public class EmployeeService implements IEmployeeService {

    public static final String PAGES_COUNT_TOKEN = "count";
    public static final String DATA_TOKEN = "data";

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DepartmentRepo departmentRepo;


    @Override
    @Transactional
    public Employee createEmployees(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Map<String,Object> getEmployees(String page,
                                           String limit,
                                           String sort) {


        Page<Employee> result = employeeRepo.findAll(PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit)));
        Map<String, Object> response = new HashMap<>();
        response.put(PAGES_COUNT_TOKEN, (result.hasContent()) ? result.getTotalPages() : 0);
        response.put(DATA_TOKEN, (result.hasContent()) ? result.getContent() : new ArrayList<>());
        return response;
    }

    @Override
    public Iterable<Department> getDepartments() {
        return departmentRepo.findAll();
    }
}
