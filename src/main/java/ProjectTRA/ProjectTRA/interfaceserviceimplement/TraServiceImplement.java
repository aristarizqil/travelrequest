/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfaceserviceimplement;

import ProjectTRA.ProjectTRA.interfacerepository.TraInterfaceRepository;
import ProjectTRA.ProjectTRA.interfaceservice.TraServiceInterface;
import ProjectTRA.ProjectTRA.model.Tra;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class TraServiceImplement implements TraServiceInterface{

    @Autowired
    private TraInterfaceRepository tir;
    
    @Override
    public Iterable<Tra> findAll() {
        return tir.findAll();
    }

    @Override
    public Tra save(Tra tra) {
        return tir.save(tra);
    }

    @Override
    public List<Tra> findByEmployee(Integer employee) {
        return tir.findByEmployee(employee);
    }


    
}
