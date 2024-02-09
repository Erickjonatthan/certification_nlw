package com.rocketseat.certification_nlw.modules.questions.record;

import java.util.UUID;

import com.rocketseat.certification_nlw.modules.questions.entities.AlternativesEntity;

public record AlternativeDetailsData(UUID id, String description) {
    public AlternativeDetailsData(AlternativesEntity result) {
        this(result.getId(), result.getDescription());
    }
}
