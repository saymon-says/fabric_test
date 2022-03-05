package com.example.fabric.service;

import com.example.fabric.dto.QuestionDto;
import com.example.fabric.model.Question;
import com.example.fabric.repository.PollRepository;
import com.example.fabric.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    private PollRepository pollRepository;

    @Override
    public Question create(QuestionDto questionDto) {
        Question newQuestion = new Question();
        newQuestion.setQuestionText(questionDto.getQuestionText());
        newQuestion.setTypeQuestion(questionDto.getTypeQuestion());
        newQuestion.setPoll(pollRepository.getById(questionDto.getIdPoll()));
        return questionRepository.save(newQuestion);
    }

    @Override
    public Question update(Long id, QuestionDto questionDto) {
        Question findQuestion = questionRepository.getById(id);
        findQuestion.setQuestionText(questionDto.getQuestionText());
        findQuestion.setTypeQuestion(questionDto.getTypeQuestion());
        return questionRepository.save(findQuestion);
    }
}
