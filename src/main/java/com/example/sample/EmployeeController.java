package com.example.sample;

import com.example.sample.persistance.common.GenericSuccess;
import com.example.sample.persistance.model.Employee;
import com.example.sample.persistance.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Kamran Majeed on 5/16/2021.
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class EmployeeController {

    private static final String EMPLOYEES = "employees";
    private static final String DEPARTMENTS = "departments";

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping(value = EMPLOYEES)
    public ResponseEntity createEmployees(@Valid @RequestBody Employee employee) {
        log.info("Create Employee Request with .{}",employee);
        return new GenericSuccess<>(employeeService.createEmployees(employee), HttpStatus.OK);
    }

    @GetMapping(value = EMPLOYEES)
    public ResponseEntity getEmployees(@RequestParam(value = "page", defaultValue = "0", required = true) String page,
                                       @RequestParam(value = "pagesize", defaultValue = "10", required = true) String limit,
                                       @RequestParam(value = "sort", defaultValue = "", required = false) String sort) {
        log.info("Get Employee Request with pagezie.{}, limit {}",page, limit);
        return new GenericSuccess<>(employeeService.getEmployees(page,limit,sort), HttpStatus.OK);

    }
    @GetMapping(value = DEPARTMENTS)
    public ResponseEntity getDepartments(@RequestParam(value = "page", defaultValue = "0", required = true) String page,
                                       @RequestParam(value = "pagesize", defaultValue = "10", required = true) String limit
                                      ) {
        log.info("Get Departments Request");
        return new GenericSuccess<>(employeeService.getDepartments(), HttpStatus.OK);

    }
}
