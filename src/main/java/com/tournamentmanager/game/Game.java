package com.tournamentmanager.game;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tournamentmanager.tournament.Tournament;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
public class Game {

    @Id
    @SequenceGenerator(name = "game_id_seq", sequenceName = "game_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
    @Column(name="game_id")
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy="game")
    @JsonManagedReference
    private List<Tournament> tournaments;

    public Game (String name){
        this.name = name;
    }
}
