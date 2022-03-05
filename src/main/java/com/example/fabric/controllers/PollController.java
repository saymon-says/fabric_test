package com.example.fabric.controllers;

import com.example.fabric.dto.PollDto;
import com.example.fabric.model.Poll;
import com.example.fabric.repository.PollRepository;
import com.example.fabric.service.PollServiceImpl;
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
import static com.example.fabric.config.WebSecurityConfig.POLL_PATH;

@RestController
@AllArgsConstructor
@RequestMapping(POLL_PATH)
public class PollController {

    private PollServiceImpl pollService;
    private PollRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Poll createPoll(@RequestBody PollDto pollDto) {
        return this.pollService.create(pollDto);
    }

    @PutMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Poll updatePoll(@PathVariable final long id, @RequestBody PollDto pollDto) {
        return this.pollService.update(id, pollDto);
    }

    @DeleteMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public void deletePoll(@PathVariable final long id) {
        this.repository.deleteById(id);
    }

    @GetMapping
    public Iterable<Poll> getPolls() {
        return this.repository.findAll();
    }

    @GetMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Poll getPoll(@PathVariable final long id) {
        return repository.findById(id).get();
    }
}
