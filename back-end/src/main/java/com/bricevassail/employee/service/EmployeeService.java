package com.bricevassail.employee.service;

import com.bricevassail.employee.entity.Employee;
import com.bricevassail.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    /**
     * Classe regroupant les méthodes pour effectuer des opérations
     * spécifiques sur les données associées aux employés, telles
     * que la création, la lecture, la mise à jour et la suppression.
     */
    private final EmployeeRepository employeeRepository;
    /**
     * Création d'un nouvel employé dans la base de données.
     *
     * @param employee : l'objet contenant les informations à sauvegarder.
     * @return : un objet de type employee généré avec un id qui s'incrémente automatiquement.
     */
    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

}
