package com.example.fabric.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;

    @JsonIgnore
    private String password;

    @JsonIgnore
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "user_poll",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "poll_id")
    )
    private Set<Poll> polls = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Answer> answers = new HashSet<>();

    public void addPoll(Poll poll) {
        this.polls.add(poll);
        poll.getUsers().add(this);
    }

    public void removePoll(Poll poll) {
        this.polls.remove(poll);
        poll.getUsers().remove(this);
    }

}
