package com.example.fabric.controllers;

import com.example.fabric.dto.PollDto;
import com.example.fabric.model.Poll;
import com.example.fabric.model.User;
import com.example.fabric.repository.PollRepository;
import com.example.fabric.repository.UserRepository;
import com.example.fabric.service.PollServiceImpl;
import com.example.fabric.service.UserServiceImpl;
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
import static com.example.fabric.config.WebSecurityConfig.POLL_PATH;

@RestController
@AllArgsConstructor
@RequestMapping(POLL_PATH)
public class PollController {

    private PollServiceImpl pollService;
    private PollRepository repository;
    private UserServiceImpl userService;
    private UserRepository userRepository;

    @Operation(summary = "Create new poll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Poll create"),
            @ApiResponse(responseCode = "403", description = "Not authorize")
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Poll createPoll(@RequestBody PollDto pollDto) {
        return this.pollService.create(pollDto);
    }

    @Operation(summary = "Update poll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Poll update"),
            @ApiResponse(responseCode = "403", description = "Not authorize"),
            @ApiResponse(responseCode = "404", description = "Poll with that id not found")
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Poll updatePoll(@Parameter(description = "Id of poll to be found")
                           @PathVariable final long id, @RequestBody PollDto pollDto) {
        return this.pollService.update(id, pollDto);
    }

    @Operation(summary = "Delete poll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Poll delete"),
            @ApiResponse(responseCode = "403", description = "Not authorize"),
            @ApiResponse(responseCode = "404", description = "Poll with that id not found")
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public void deletePoll(@Parameter(description = "Id of poll to be found")
                           @PathVariable final long id) {
        User findUser = userService.findByAuthentication();
        Poll findPoll = repository.findById(id).get();
        findUser.removePoll(findPoll);
        userRepository.save(findUser);
        this.repository.deleteById(id);
    }

    @Operation(summary = "Get list of all polls")
    @ApiResponse(responseCode = "200", description = "List of all polls")
    @GetMapping
    public Iterable<Poll> getPolls() {
        return this.repository.findAll();
    }

    @Operation(summary = "Get poll by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Poll found"),
            @ApiResponse(responseCode = "404", description = "Poll with that id not found")
    })
    @GetMapping(ID_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Poll getPoll(@Parameter(description = "Id of poll to be found")
                        @PathVariable final long id) {
        User findUser = userService.findByAuthentication();
        Poll findPoll = repository.findById(id).get();
        findUser.addPoll(findPoll);
        userRepository.save(findUser);
        return findPoll;
    }

}
