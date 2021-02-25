package com.humanbooster.api_rest_demo;

import com.humanbooster.api_rest_demo.model.Candidat;
import com.humanbooster.api_rest_demo.repository.CandidatRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
class ApiRestDemoApplicationTests {

    @Autowired
    private CandidatRepository candidatRepository;

    
    /*Attention un candidat est créer si le bdd est vide. A prendre en compte lors des tests*/
    
    @Test
    void testDefaultData() {
        Candidat candidat = new Candidat("test@gmail.com", "test_password", "testNom", "testPrenom");
        
        this.candidatRepository.save(candidat);
        
        List<Candidat> candidats = this.candidatRepository.findAll();
        
        Assertions.assertEquals(candidats.size(), 2);
    }
}
