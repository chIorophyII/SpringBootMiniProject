package com.sparta.hanghaemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sparta.hanghaemini.dto.SignupRequestDto;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;

    private String nickname;

    private String password;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public User(String username, String nickname, String password) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }

    public User(String nickname) {
        this.nickname = nickname;
    }

    public void changeTeam(Team foundteam) {
        this.team = foundteam;
    }

    public void removeTeam(Team foundteam) {
        this.team = null;
    }
}
