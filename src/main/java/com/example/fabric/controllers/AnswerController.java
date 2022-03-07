package com.example.fabric.controllers;

import com.example.fabric.dto.AnswerDto;
import com.example.fabric.model.Answer;
import com.example.fabric.service.AnswerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fabric.config.WebSecurityConfig.ANSWER_PATH;

@RestController
@AllArgsConstructor
@RequestMapping(ANSWER_PATH)
public class AnswerController {

    private AnswerServiceImpl answerService;

    @Operation(summary = "Create answer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful create"),
            @ApiResponse(responseCode = "401", description = "Not authorized")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Answer createAnswer(@RequestBody AnswerDto answerDto) {
        return this.answerService.create(answerDto);
    }

}
