package com.example.fabric.controllers;

import com.example.fabric.dto.QuestionDto;
import com.example.fabric.model.Question;
import com.example.fabric.repository.QuestionRepository;
import com.example.fabric.service.QuestionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Operation(summary = "Create new question")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Question create"),
            @ApiResponse(responseCode = "403", description = "Not authorize")
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Question createQuestion(@RequestBody QuestionDto questionDto) {
        return this.questionService.create(questionDto);
    }

    @Operation(summary = "Update question")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Question update"),
            @ApiResponse(responseCode = "403", description = "Not authorize"),
            @ApiResponse(responseCode = "404", description = "Question with that id not found")
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Question updateQuestion(@Parameter(description = "Id of question to be found")
                                   @PathVariable final long id, @RequestBody QuestionDto questionDto) {
        return this.questionService.update(id, questionDto);
    }

    @Operation(summary = "Delete question")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Question delete"),
            @ApiResponse(responseCode = "403", description = "Not authorize"),
            @ApiResponse(responseCode = "404", description = "Question with that id not found")

    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public void deleteQuestion(@Parameter(description = "Id of question to be found")
                               @PathVariable final long id) {
        this.repository.deleteById(id);
    }

    @Operation(summary = "Get question by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Question found"),
            @ApiResponse(responseCode = "404", description = "Question with that id not found")
    })
    @GetMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Question getQuestion(@Parameter(description = "Id of question to be found")
                                @PathVariable final long id) {
        return repository.findById(id).get();
    }

}
