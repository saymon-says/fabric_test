package com.example.fabric.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "answers")
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @EmbeddedId
    private AnswerKey answerKey;

    private String answer;

    @ManyToOne
    @JsonIgnore
    private Poll poll;

}
