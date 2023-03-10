package com.tournamentmanager.tournament;

import com.tournamentmanager.match.Match;
import com.tournamentmanager.team.Team;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
@Slf4j
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public List<Match> generateSEMatches(Long tournamentId){
        log.warn("log test");
        Optional<Tournament> tournament = tournamentRepository.findById(tournamentId);
        Random rand = new Random();
        if (tournament.get().getMatches().isEmpty()) {
            Set<Team> enrolled = tournament.get().getTeams();

            // Remove one team randomly if there is even number of teams enrolled
            if (enrolled.size()%2!=0){
                tournament.get().getTeams().remove(
                        tournament.get().getTeams().stream().toList().get(
                                rand.nextInt(enrolled.size())
                        )
                );
            }
            List<Team> teams = new ArrayList<>(enrolled.stream().toList());
            //List<Team> teams = enrolled.stream().toList();
            List<Match> matches = new ArrayList<>();
            while (!teams.isEmpty()) {
                int randomTeam = rand.nextInt(teams.size());
                Match match = new Match(teams.get(0),teams.get(randomTeam),1 ,tournament.get());
                matches.add(match);
                teams.remove(randomTeam);
                teams.remove(0);
            }
            tournament.get().setMatches(matches);
            tournamentRepository.save(tournament.get());
        }

        return tournament.get().getMatches();
    }
}
