package com.bricevassail.employee.controller;

import com.bricevassail.employee.entity.Employee;
import com.bricevassail.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
    /**
     * Classe servant à faire les requêtes HTTP.
     */
    private final EmployeeService employeeService;

    /**
     * Création d'un employé dans la base de donnée
     * @param employee : donnée à sauvegarder dans la base de données.
     *                 Les données sont à renseigner dans la requête POST.
     * @return : L'employé avec les infos de la requête POST et l'id généré.
     */
    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeService.postEmployee(employee);
    }

}
