package com.example.sample.persistance.repos;

import com.example.sample.persistance.model.Department;
import com.example.sample.persistance.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kamran Majeed on 5/16/2021.
 */

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {


}
