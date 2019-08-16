/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfaceservice;

import ProjectTRA.ProjectTRA.model.Tra;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ASUS
 */
public interface TraServiceInterface {
    
    Iterable<Tra> findAll();
    
    Tra save(Tra tra);
    
    List<Tra> findByEmployee(Integer employee);
}
