package com.geekster.EmployeeAddress.repository;

import com.geekster.EmployeeAddress.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee,Long> {

    public Employee findEmployeeById(Long id);
}
