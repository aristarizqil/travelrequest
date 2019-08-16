/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfaceserviceimplement;

import ProjectTRA.ProjectTRA.interfacerepository.EmployeeInterfaceRepository;
import ProjectTRA.ProjectTRA.interfacerepository.LetterInterfaceRepository;
import ProjectTRA.ProjectTRA.interfaceservice.LetterServiceInterface;
import ProjectTRA.ProjectTRA.model.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class LetterServiceImplement implements LetterServiceInterface{
    @Autowired
    private LetterInterfaceRepository lir;

    @Override
    public Iterable<Letter> findAllLetter() {
        return lir.findAll();
    }
    
}
