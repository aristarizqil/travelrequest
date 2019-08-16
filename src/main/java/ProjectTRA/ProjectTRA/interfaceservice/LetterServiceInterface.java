/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.interfaceservice;

import ProjectTRA.ProjectTRA.model.Letter;

/**
 *
 * @author USER
 */
public interface LetterServiceInterface {
    Iterable<Letter> findAllLetter();
}
