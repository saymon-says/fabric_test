package com.example.fabric.controllers;

import com.example.fabric.dto.AnswerDto;
import com.example.fabric.model.Answer;
import com.example.fabric.model.Question;
import com.example.fabric.repository.AnswerRepository;
import com.example.fabric.service.AnswerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import static com.example.fabric.config.WebSecurityConfig.ANSWER_PATH;
import static com.example.fabric.config.WebSecurityConfig.ID_PATH;

@RestController
@AllArgsConstructor
@RequestMapping(ANSWER_PATH)
public class AnswerController {

    private AnswerRepository repository;

    private AnswerServiceImpl answerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Answer createAnswer(@RequestBody AnswerDto answerDto) {
        return this.answerService.create(answerDto);
    }

//    @GetMapping(ID_PATH)
//    @ResponseStatus(HttpStatus.OK)
//    public Iterable<Answer> getQuestions(@PathVariable final long id) {
//        return this.repository.findAllById(Collections.singleton(id));
//    }

}
