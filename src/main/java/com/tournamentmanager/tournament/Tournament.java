package com.tournamentmanager.tournament;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tournamentmanager.game.Game;
import com.tournamentmanager.match.Match;
import com.tournamentmanager.team.Team;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
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

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="game_id", nullable = false)
    @JsonBackReference
    private Game game;


    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy="tournament")
    @Column(nullable = false)
    @JsonManagedReference
    private List<Match> matches;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="enrolled", joinColumns = {@JoinColumn(name="tournament_id")},
            inverseJoinColumns = { @JoinColumn(name="team_id")})
    @JsonManagedReference
    private Set<Team> teams = new HashSet<Team>();

    public Tournament (String name, Game game) {
        super();
        this.name = name;
        this.game = game;
    }
}
