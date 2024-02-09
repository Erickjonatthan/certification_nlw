package com.rocketseat.certification_nlw.modules.students.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certifications_students")
@Builder
public class CertificationStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "student_id")
    private UUID studentID;

    @Column(length =  100)
    private String technology;

    @Column(length =  10)    
    private int grade;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", updatable = false, insertable = false)
    private StudentEntity studentEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_certification_id", referencedColumnName = "id", updatable = false, insertable = false)
    @JsonManagedReference
    private List<AnswersCertificationsEntity> answersCertificationsEntities;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
