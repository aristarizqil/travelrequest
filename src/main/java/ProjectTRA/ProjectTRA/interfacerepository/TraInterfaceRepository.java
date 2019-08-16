/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfacerepository;

import ProjectTRA.ProjectTRA.model.Tra;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface TraInterfaceRepository extends CrudRepository<Tra, Integer>{
    @Query(value = "SELECT * FROM tra WHERE employee =?1",
            nativeQuery = true)
    public List<Tra> findByEmployee(int employee);
}
