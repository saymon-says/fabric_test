package com.example.fabric.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.DATE;

@Entity
@Getter
@Setter
@Table(name = "polls")
@AllArgsConstructor
@NoArgsConstructor
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "poll",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Question> questions;

    @OneToMany(mappedBy = "poll",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @CreationTimestamp
    @Temporal(DATE)
    private Date createdAt;

    @CreationTimestamp
    @Temporal(DATE)
    private Date closedAt;
}
