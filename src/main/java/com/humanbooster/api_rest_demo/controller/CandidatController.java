/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.api_rest_demo.controller;

import com.humanbooster.api_rest_demo.model.Candidat;
import com.humanbooster.api_rest_demo.repository.CandidatRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author HB
 */
@RestController
@RequestMapping("/api")
public class CandidatController {

    @Autowired
    private CandidatRepository candidatRepository;

    @GetMapping("/candidats")
    List<Candidat> all() {
        return candidatRepository.findAll();
    }

    @GetMapping(value = "/{candidat}", produces = {"application/json"})
    Candidat getOne(@PathVariable(name = "candidat", required = false) Candidat candidat) {
        if (candidat == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Candidat introuvable"
            );
        } else {
            return candidat;
        }
    }

    @PostMapping(value = "/candidats", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Candidat> saveCandidat(@Valid @RequestBody Candidat candidat) {

        this.candidatRepository.save(candidat);
        return new ResponseEntity<Candidat>(candidat, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{candidat}", produces = {"application/json"})
    public ResponseEntity<Candidat> update(@PathVariable(name = "candidat", required = false) Candidat candidat, @Valid @RequestBody Candidat candidatUpdate) {

        if (candidat == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidat Introuvable");
        }

        candidatUpdate.setId(candidat.getId());
        this.candidatRepository.save(candidatUpdate);

        return new ResponseEntity<Candidat>(candidat, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{candidat}", produces = {"application/json"}) 
    void deleteOne(@PathVariable(name="candidat", required = false)Candidat candidat){
        if(candidat == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidat introuvable");
        } else {
            this.candidatRepository.delete(candidat);
        }
    }
}
