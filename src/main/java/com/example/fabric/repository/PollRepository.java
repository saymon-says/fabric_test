package com.example.fabric.repository;

import com.example.fabric.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
    Poll findByQuestionsId(Long id);
}
