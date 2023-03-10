package com.tournamentmanager.match;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tournamentmanager.team.Team;
import com.tournamentmanager.tournament.Tournament;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
public class Match {

    @Id
    @SequenceGenerator(name = "match_id_seq", sequenceName = "match_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "match_id_seq")
    @Column(name="match_id")
    private Long id;

    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="team_a", nullable = false)
    @JsonManagedReference
    private Team team_a;

    @Getter
    @Setter
    @Column(nullable = true)
    private int score_team_a;

    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="team_b", nullable = false)
    @JsonManagedReference
    private Team team_b;

    @Getter
    @Setter
    @Column(nullable = true)
    private int score_team_b;

    @Getter
    @Setter
    @Column(nullable = false)
    private int phase;

    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tournament", nullable = false)
    @JsonBackReference
    private Tournament tournament;


    public Match (Team team_a, Team team_b, int phase, Tournament tournament) {
        super();
        this.team_a = team_a;
        this.team_b = team_b;
        this.phase  = phase;
        this.tournament = tournament;
    }

}
