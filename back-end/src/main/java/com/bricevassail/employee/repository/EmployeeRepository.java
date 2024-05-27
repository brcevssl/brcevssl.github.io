package com.bricevassail.employee.repository;

import com.bricevassail.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Classe permettant les interactions avec la base de données.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
