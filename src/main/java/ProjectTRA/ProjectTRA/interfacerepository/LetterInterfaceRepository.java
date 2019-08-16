/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfacerepository;

import ProjectTRA.ProjectTRA.model.Letter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface LetterInterfaceRepository extends CrudRepository<Letter, Integer>{
    
}
