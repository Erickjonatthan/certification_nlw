package com.rocketseat.certification_nlw.modules.questions.record;

import java.util.List;
import java.util.UUID;

import com.rocketseat.certification_nlw.modules.questions.entities.QuestionEntity;

public record QuestionDetailsData(UUID id, String description, String technology) {
    public QuestionDetailsData(QuestionEntity result) {
        this(result.getId(), result.getDescription(), result.getTechnology());
    }
}
