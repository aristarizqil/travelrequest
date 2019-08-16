/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfaceservice;

import ProjectTRA.ProjectTRA.model.Employee;
import java.util.Optional;

/**
 *
 * @author USER
 */
public interface EmployeeServiceInterface {
    
    Iterable<Employee> findAll();
    
    void delete(Integer id);
    
    Optional<Employee> findById(Integer id);
    
    Employee save(Employee employee);
    
    Employee findByEmail(String email);
    
}
