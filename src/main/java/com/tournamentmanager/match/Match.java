package com.tournamentmanager.match;

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
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="team_a")
    private Team team_a;

    @Getter
    @Setter
    private int score_team_a;

    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="team_b")
    private Team team_b;

    @Getter
    @Setter
    private int score_team_b;

    @Getter
    @Setter
    private int phase;

    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tournament")
    private Tournament tournament;


    public Match (Team team_a, Team team_b, int phase, Tournament tournament) {
        super();
        this.team_a = team_a;
        this.team_b = team_b;
        this.phase  = phase;
        this.tournament = tournament;
    }

}
