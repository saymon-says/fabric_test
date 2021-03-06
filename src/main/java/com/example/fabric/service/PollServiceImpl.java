package com.example.fabric.service;

import com.example.fabric.dto.PollDto;
import com.example.fabric.model.Poll;
import com.example.fabric.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class PollServiceImpl implements PollService {

    private PollRepository pollRepository;

    @Override
    public Poll create(PollDto pollDto) {
        Poll newPoll = new Poll();
        newPoll.setName(pollDto.getName());
        newPoll.setDescription(pollDto.getDescription());
        newPoll.setCreatedAt(pollDto.getCreatedAt());
        newPoll.setClosedAt(pollDto.getClosedAt());
        return pollRepository.save(newPoll);
    }

    @Override
    public Poll update(Long id, PollDto pollDto) {
        Poll findPoll = pollRepository.getById(id);
        findPoll.setName(pollDto.getName());
        findPoll.setClosedAt(pollDto.getClosedAt());
        findPoll.setDescription(pollDto.getDescription());
        return pollRepository.save(findPoll);
    }
}
