package com.tournamentmanager.tournament;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tournamentmanager.game.Game;
import com.tournamentmanager.match.Match;
import com.tournamentmanager.team.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Tournament {

    @Id
    @SequenceGenerator(name = "tournament_id_seq", sequenceName = "tournament_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_id_seq")
    @Column(name="tournament_id")
    private Long id;

    @Column(nullable = false)
    @Setter
    private String name;

    @Column(nullable = false)
    @Setter
    private int phases;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="game_id", nullable = false)
    @JsonManagedReference
    @Setter
    private Game game;

    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy="tournament")
    @Column(nullable = false)
    @JsonManagedReference
    private List<Match> matches;

    @Setter
    @ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinTable(name="enrolled", joinColumns = {@JoinColumn(name="tournament_id")},
            inverseJoinColumns = { @JoinColumn(name="team_id")})
    private List<Team> teams;

}
