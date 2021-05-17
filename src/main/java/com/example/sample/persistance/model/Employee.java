package com.example.sample.persistance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import javax.print.DocFlavor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Kamran Majeed on 5/16/2021.
 */
@Data
@Entity
public class Employee {

    @Id
    @Column( length = 6)
    @GeneratedValue
    private int employeeId;
    @Basic
    @Column( nullable = false, length = 20)
    @NotBlank(message = "First Name must not be empty")
    @Size(min = 2,message = "first Name must be more than 2 char")
    private String firstName;
    @Basic
    @Column( nullable = false , length = 25)
    @NotBlank(message = "Last Name is  mut not be emtpy")
    @Size(min = 2,message ="first Name must be more than 2 char")
    private String lastName;
    @Basic
    @Column( length = 25)
    private String email;
    @Basic
    @Column( length = 20)
    @Pattern(regexp="[0-9/-]+",message = "Phone Number must only Contain Digits and dashes")
    private String phoneNumber;
    @Basic
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "IST")

    private LocalDate hireDate;
    @Basic
    @Column( length = 8, precision = 8, scale = 2)
    @Positive(message = "Salary must be greater than 0")
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties({"employees"})
    private Department department;

    @ManyToOne
    @JoinColumn(name="manager_id")
    private Employee manager;



}
