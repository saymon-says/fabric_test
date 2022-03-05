package com.example.fabric.dto;

import com.example.fabric.model.TypeQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private String questionText;
    private TypeQuestion typeQuestion;
    private Long idPoll;
}
