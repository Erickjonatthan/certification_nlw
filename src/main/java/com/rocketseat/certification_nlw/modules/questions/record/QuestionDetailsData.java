package com.rocketseat.certification_nlw.modules.questions.record;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.rocketseat.certification_nlw.modules.questions.entities.QuestionEntity;

public record QuestionDetailsData(UUID id, String description, String technology,List<AlternativeDetailsData> alternatives) {
    
    public QuestionDetailsData(QuestionEntity result) {
        this(result.getId(), result.getDescription(), result.getTechnology(),result.getAlternatives().stream().map(AlternativeDetailsData::new).collect(Collectors.toList()));
    }
}
