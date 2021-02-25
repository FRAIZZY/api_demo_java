/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.api_rest_demo.repository;

import com.humanbooster.api_rest_demo.model.Candidat;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HB
 */
@Repository
public interface CandidatRepository extends CrudRepository<Candidat, Integer>{
    List<Candidat> findAll();
}
