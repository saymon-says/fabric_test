package com.example.fabric.controllers;

import com.example.fabric.dto.QuestionDto;
import com.example.fabric.model.Question;
import com.example.fabric.repository.QuestionRepository;
import com.example.fabric.service.QuestionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fabric.config.WebSecurityConfig.ID_PATH;
import static com.example.fabric.config.WebSecurityConfig.QUESTION_PATH;

@RestController
@AllArgsConstructor
@RequestMapping(QUESTION_PATH)
public class QuestionController {

    private QuestionRepository repository;

    private QuestionServiceImpl questionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Question createQuestion(@RequestBody QuestionDto questionDto) {
        return this.questionService.create(questionDto);
    }

    @PutMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Question updateQuestion(@PathVariable final long id, @RequestBody QuestionDto questionDto) {
        return this.questionService.update(id, questionDto);
    }

    @DeleteMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public void deleteQuestion(@PathVariable final long id) {
        this.repository.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Question> getQuestions() {
        return this.repository.findAll();
    }

    @GetMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Question getQuestion(@PathVariable final long id) {
        return repository.findById(id).get();
    }

}
