package com.tournamentmanager.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tournamentmanager.team.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Changed table name to app_users to avoid conflict with user keyword in postgresql
@Entity
@Table (name="app_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class User{
    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @Column(name="user_id")
    private Long id;

    @Column(nullable = false)
    @Setter
    private String nick;

    @Column(nullable = false)
    @Setter
    private String email;

    @Column(nullable = false)
    @Setter
    private String password;



    @Setter
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="team_member", joinColumns = {@JoinColumn(name="user_id")},
                inverseJoinColumns = { @JoinColumn(name="team_id")})
    @JsonBackReference
    private List<Team> teams;

    public User(String nick, String email, String password){
        super();
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

}
