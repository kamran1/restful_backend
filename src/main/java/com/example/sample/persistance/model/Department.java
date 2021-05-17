package com.example.sample.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Kamran Majeed on 5/16/2021.
 */
@Data
@Entity
public class Department {

    @Id
    @Column(length = 6)
    private Integer departmentId;
    @Basic
    @Column(length = 30)
    private String  departmentName;
    @Basic
    @Column(length = 6)
    private Integer managerId;

    @OneToMany
    @JoinColumn(name="department_id")
    @JsonIgnoreProperties("department")
    private List<Employee> employees;




}
