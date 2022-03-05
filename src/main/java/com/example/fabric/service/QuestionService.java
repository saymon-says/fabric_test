package com.example.fabric.service;

import com.example.fabric.dto.QuestionDto;
import com.example.fabric.model.Question;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {

    Question create(QuestionDto questionDto);

    Question update(Long id, QuestionDto questionDto);

}
