package com.example.fabric.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerKey implements Serializable {

    private Long question_id;

    private Long user_id;

}
