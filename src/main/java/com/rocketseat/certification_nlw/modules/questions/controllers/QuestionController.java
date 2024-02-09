package com.rocketseat.certification_nlw.modules.questions.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.questions.record.AlternativeDetailsData;
import com.rocketseat.certification_nlw.modules.questions.record.QuestionDetailsData;
import com.rocketseat.certification_nlw.modules.questions.repositories.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public ResponseEntity getQuestionsByTechnology(@PathVariable String technology) {
        
        var question = this.questionRepository.findByTechnology(technology);
    
        List<AlternativeDetailsData> alternativesData = question.stream().map(entity -> entity.getAlternatives().stream().map(AlternativeDetailsData::new).collect(Collectors.toList())).flatMap(List::stream).collect(Collectors.toList());

        List<QuestionDetailsData> questionDetails = question.stream()
        .map(entity -> new QuestionDetailsData(entity.getId(), entity.getDescription(), entity.getTechnology(),alternativesData))
        .collect(Collectors.toList());
    
        return ResponseEntity.ok(questionDetails);
    }


}
