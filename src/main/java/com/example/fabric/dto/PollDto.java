package com.example.fabric.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollDto {

    private String name;

    private String description;

    private long userId;

    private Date createdAt;

    private Date closedAt;

}
