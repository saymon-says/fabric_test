package com.example.fabric.controllers;

import com.example.fabric.model.User;
import com.example.fabric.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fabric.config.WebSecurityConfig.ID_PATH;
import static com.example.fabric.config.WebSecurityConfig.USER_PATH;

@RestController
@AllArgsConstructor
@RequestMapping(USER_PATH)
public class UserController {

    private UserRepository userRepository;

    @Operation(summary = "Get user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User with that id not found")
    })
    @GetMapping(ID_PATH)
    public User getUser(@Parameter(description = "Id of user to be found")
                        @PathVariable final long id) {
        return this.userRepository.findById(id).get();
    }

}
