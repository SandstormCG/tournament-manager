package com.tournamentmanager.team;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tournamentmanager.match.Match;
import com.tournamentmanager.tournament.Tournament;
import com.tournamentmanager.user.User;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Team {
    @Id
    @SequenceGenerator(name = "team_id_seq", sequenceName = "team_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_seq")
    @Column(name="team_id")
    private Long id;

    @Column(nullable = false)
    @Setter
    private String name;

    @Column(nullable = false)
    @Setter
    private int size;

    @ManyToMany(mappedBy="teams")
    @Setter
    @JsonManagedReference
    private Set<User> players = new HashSet<User>();

    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy="team_a")
    @JsonBackReference
    private List<Match> matches_a;

    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy="team_b")
    @JsonBackReference
    private List<Match> matches_b;

    @ManyToMany(mappedBy="teams")
    @Setter
    private Set<Tournament> tournaments = new HashSet<Tournament>();

    public Team(String name, int size){
        super();
        this.name = name;
        this.size = size;
    }



}
