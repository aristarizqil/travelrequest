/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfaceserviceimplement;

import ProjectTRA.ProjectTRA.interfacerepository.RoleInterfaceRepository;
import ProjectTRA.ProjectTRA.interfaceservice.RoleServiceInterface;
import ProjectTRA.ProjectTRA.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class RoleServiceImplement implements RoleServiceInterface{
    
    @Autowired
    private RoleInterfaceRepository rir;

    @Override
    public Iterable<Role> findall() {
        return rir.findAll();
    }
    
}
