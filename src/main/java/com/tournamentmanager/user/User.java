package com.tournamentmanager.user;

import com.tournamentmanager.team.Team;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

// Change table name to app_users to avoid conflict with user keyword in postgresql
@Entity
@Table (name="app_users")
@NoArgsConstructor
public class User{
    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @Column(name="user_id")
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String nick;

    @Column(nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(nullable = false)
    @Getter
    @Setter
    private String password;


    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="team_member", joinColumns = {@JoinColumn(name="user_id")},
                inverseJoinColumns = { @JoinColumn(name="team_id")})
    private Set<Team> teams = new HashSet<Team>();

    public User(String nick, String email, String password){
        super();
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

}
