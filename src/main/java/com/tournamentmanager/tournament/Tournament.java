package com.tournamentmanager.tournament;

import com.tournamentmanager.game.Game;
import com.tournamentmanager.match.Match;
import com.tournamentmanager.team.Team;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
public class Tournament {

    @Id
    @SequenceGenerator(name = "tournament_id_seq", sequenceName = "tournament_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_id_seq")
    @Column(name="tournament_id")
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="game")
    private Game game;


    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy="tournament")
    private List<Match> matches;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="enrolled", joinColumns = {@JoinColumn(name="tournament_id")},
            inverseJoinColumns = { @JoinColumn(name="team_id")})
    private Set<Team> teams = new HashSet<Team>();

    public Tournament (String name, Game game) {
        super();
        this.name = name;
        this.game = game;
    }
}
