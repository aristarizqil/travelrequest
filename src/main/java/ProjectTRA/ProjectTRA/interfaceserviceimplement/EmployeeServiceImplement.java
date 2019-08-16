/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfaceserviceimplement;

import ProjectTRA.ProjectTRA.interfacerepository.EmployeeInterfaceRepository;
import ProjectTRA.ProjectTRA.interfaceservice.EmployeeServiceInterface;
import ProjectTRA.ProjectTRA.model.Employee;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class EmployeeServiceImplement implements EmployeeServiceInterface{
    
    @Autowired
    private EmployeeInterfaceRepository eir;

    @Override
    public Iterable<Employee> findAll() {
        return eir.findAll();
    }

    @Override
    public void delete(Integer id) {
        eir.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return eir.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return eir.save(employee);
    }

    @Override
    public Employee findByEmail(String email) {
        return eir.findByEmail(email);
    }
    
}
