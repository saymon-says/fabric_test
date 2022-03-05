package com.example.fabric.service;

import com.example.fabric.dto.PollDto;
import com.example.fabric.model.Poll;
import org.springframework.stereotype.Service;

@Service
public interface PollService {

    Poll create(PollDto pollDto);

    Poll update(Long id, PollDto pollDto);

}
