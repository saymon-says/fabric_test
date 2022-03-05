package com.example.fabric.service;

import com.example.fabric.dto.AnswerDto;
import com.example.fabric.model.Answer;
import org.springframework.stereotype.Service;

@Service
public interface AnswerService {

    Answer create(AnswerDto answerDto);

}
