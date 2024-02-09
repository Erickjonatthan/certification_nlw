package com.rocketseat.certification_nlw.modules.students.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCertificationAnswerDTO {
    
    private String email;
    private String technology;
    private List<QuestionAnswerDTO> answer;

}
