package com.tournamentmanager.match;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tournamentmanager.team.Team;
import com.tournamentmanager.tournament.Tournament;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Match {

    @Id
    @SequenceGenerator(name = "match_id_seq", sequenceName = "match_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "match_id_seq")
    @Column(name="match_id")
    private Long id;

    @Setter
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="team_a", nullable = true)
    @JsonManagedReference
    private Team team_a;

    @Setter
    @Column(nullable = true)
    private int score_team_a;

    @Setter
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="team_b", nullable = true)
    @JsonManagedReference
    private Team team_b;

    @Setter
    @Column(nullable = true)
    private int score_team_b;

    @Setter
    @Column(nullable = false)
    private int phase;

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

    public Match (Team team_a, int score_team_a, Team team_b, int score_team_b, int phase, Tournament tournament) {
        super();
        this.team_a = team_a;
        this.score_team_a = score_team_a;
        this.team_b = team_b;
        this.score_team_b = score_team_b;
        this.phase  = phase;
        this.tournament = tournament;
    }

}
