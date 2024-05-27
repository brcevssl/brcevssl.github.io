package com.bricevassail.employee.service;

import com.bricevassail.employee.entity.Employee;
import com.bricevassail.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee postEmployee(Employee employee){
        System.out.println("EmployeeService created. employeeRepository: " + employeeRepository);
        return employeeRepository.save(employee);
    }

}

