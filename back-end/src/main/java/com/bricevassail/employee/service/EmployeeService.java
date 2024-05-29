package com.bricevassail.employee.service;

import com.bricevassail.employee.entity.Employee;
import com.bricevassail.employee.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/**
 * Classe regroupant les méthodes pour effectuer des opérations
 * spécifiques sur les données associées aux employés, telles
 * que la création, la lecture, la mise à jour et la suppression.
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * Obtention d'un employé par son id.
     * @return : l'employé.
     */
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    /**
     * Obtention d'une liste contenant tous
     * les employés de la base de données.
     * @return : liste contenant tous
     *         les employés de la base de données.
     */
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    /**
     * Création d'un nouvel employé dans la base de données.
     *
     * @param employee : l'objet contenant les
     *                 informations à sauvegarder.
     * @return : un objet de type employee généré avec un
     *         id qui s'incrémente automatiquement.
     */
    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    /**
     * Suppression d'un client dans la base de données.
     * @param id : id de l'employé à supprimer.
     */
    public void deleteEmployee(Long id){
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee with ID " + id + " not found.");
        }
        employeeRepository.deleteById(id);
    }

    /**
     * Modification des informations de l'employé.
     * @param id : Id de l'employé à modifier.
     * @param employee : Employé.
     * @return Employé avec ses informations modifiées.
     */
    public Employee updateEmployee(Long id, Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existringEmployee = optionalEmployee.get();
            existringEmployee.setName(employee.getName());
            existringEmployee.setEmail(employee.getEmail());
            existringEmployee.setPhone(employee.getPhone());
            existringEmployee.setDepartment(employee.getDepartment());

            return employeeRepository.save(existringEmployee);
        }
        return null;
    }
}
