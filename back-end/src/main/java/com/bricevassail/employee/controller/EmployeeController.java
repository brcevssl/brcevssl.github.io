package com.bricevassail.employee.controller;

import com.bricevassail.employee.entity.Employee;
import com.bricevassail.employee.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

/**
 * Classe servant à faire les requêtes HTTP.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Obtention d'un employé par son id.
     * @param id : id de l'employé.
     * @return : l'employé.
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    /**
     * Obtention d'une liste contenant tous
     * les employés de la base de données.
     * @return : liste contenant tous
     *         les employés de la base de données
     */
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Création d'un nouvel employé dans la base de donnée.
     * @param employee : donnée à sauvegarder dans la base de données.
     *                 Les données sont à renseigner dans la requête POST.
     * @return : L'employé avec les infos de la requête POST et l'id généré.
     */
    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeService.postEmployee(employee);
    }

    /**
     * Suppression d'un client dans la base de données.
     * @param id : id de l'employé à supprimer.
     * @return : réponse HTTP à la requête.
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(
                    "Employee with ID " + id
                            + " deleted successfully.", HttpStatus.OK
            );
        }
        catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Modification des informations de l'employé.
     * @param id : Id de l'employé à modifier.
     * @param employee : Employé.
     * @return Employé avec ses informations modifiées.
     */
    @PatchMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatedEmployee);
    }
}
