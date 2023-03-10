package com.tournamentmanager.game;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tournamentmanager.tournament.Tournament;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Game {

    @Id
    @SequenceGenerator(name = "game_id_seq", sequenceName = "game_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
    @Column(name="game_id")
    private Long id;

    @Column(nullable = false)
    @Setter
    private String name;

    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy="game")
    @JsonBackReference
    private List<Tournament> tournaments;

    public Game (String name){
        this.name = name;
    }
}
