// TEAM MEMBERS:

// Abhinav Veeragandham - G01515455
// Pranav Vangavety - G01511443
// Charan Sri Sai Devalla - G01504177
// Bhogeswara Pathakamudi - G01507114
// Durga Shankar Kondaveeti - G01510533
// Chinmaya Raz Vaiisshnav Maddi - G01504185
// Naga Venkata Sai Chennu - G01514409
// Abhiram Kolisetty - G01506075

// This file is Spring Boot REST Controller that handles HTTP requests.

package com.assignment4.controller;

import com.assignment4.model.Survey;
import com.assignment4.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "*")
public class SurveyController {

    @Autowired
    private SurveyRepository repo;

    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return repo.save(survey);
    }

    @GetMapping
    public List<Survey> getAllSurveys() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey updated) {
        return repo.findById(id).map(existing -> {
            updated.setId(id);
            return ResponseEntity.ok(repo.save(updated));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

