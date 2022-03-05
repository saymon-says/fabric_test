package com.example.fabric.service;

import com.example.fabric.dto.AnswerDto;
import com.example.fabric.model.Answer;
import com.example.fabric.model.AnswerKey;
import com.example.fabric.repository.AnswerRepository;
import com.example.fabric.repository.PollRepository;
import com.example.fabric.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    private UserServiceImpl userService;

    private QuestionRepository questionRepository;

    private PollRepository pollRepository;

    @Override
    public Answer create(AnswerDto answerDto) {
        Answer newAnswer = new Answer();
        newAnswer.setAnswer(answerDto.getAnswer());
        newAnswer.setAnswerKey(new AnswerKey(answerDto.getIdQuestion(), userService.findByAuthentication().getId()));
        newAnswer.setPoll(pollRepository.findByQuestionsId(answerDto.getIdQuestion()));
        return answerRepository.save(newAnswer);
    }

}
