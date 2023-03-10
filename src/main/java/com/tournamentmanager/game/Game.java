package com.tournamentmanager.game;

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

    public Game (String name){
        this.name = name;
    }
}
