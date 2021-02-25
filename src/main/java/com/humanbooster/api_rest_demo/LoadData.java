/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.api_rest_demo;

import com.humanbooster.api_rest_demo.model.Candidat;
import com.humanbooster.api_rest_demo.repository.CandidatRepository;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author HB
 */
@Configuration
public class LoadData {
    private static final Logger log = LoggerFactory.getLogger(LoadData.class);
    
    @Bean
    CommandLineRunner initDataBase(CandidatRepository candidatRepository) throws ParseException {
        if(candidatRepository.count() == 0) {
            Candidat candidat = new Candidat("toto@gmail.com", "toto_password", "TITI", "toto");
            
            return args -> {
                log.info("Preloading " + candidatRepository.save(candidat));
            };
                    
        } else {
            return args -> {
                log.info("Already init !");
            };
        }
    }
}
