/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfacerepository;

import ProjectTRA.ProjectTRA.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface EmployeeInterfaceRepository extends CrudRepository<Employee, Integer>{
    
    @Query(value = "SELECT * FROM employee WHERE email =?1",
            nativeQuery = true)
    public Employee findByEmail(String email);
}
