package com.geekster.EmployeeAddress.controllers;

import com.geekster.EmployeeAddress.models.Employee;
import com.geekster.EmployeeAddress.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    IEmployeeRepository employeeRepository;

    @PostMapping(value="/employees")
    public void createEmployee(@RequestBody Employee employee) {
         employeeRepository.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    @PutMapping("update/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employeeRequest) {
          Employee employee= employeeRepository.findEmployeeById(id);
          employee.setFirstName(employeeRequest.getFirstName());
          employee.setLastName(employeeRequest.getLastName());
          employee.setAddress(employeeRequest.getAddress());
          employeeRepository.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }


}
