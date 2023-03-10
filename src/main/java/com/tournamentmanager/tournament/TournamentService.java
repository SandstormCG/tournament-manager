package com.tournamentmanager.tournament;

import com.tournamentmanager.match.Match;
import com.tournamentmanager.match.MatchRepository;
import com.tournamentmanager.team.Team;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
@Slf4j
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    private final MatchRepository matchRepository;

    @Transactional
    public List<Match> generateSEMatches(Long tournamentId) throws Exception {
        //log.warn("log test");
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new Exception("Tournament not found") );
        if (tournament.getMatches().isEmpty()) {
            Set<Team> enrolled = tournament.getTeams();
            List<Match> matches = new ArrayList<>();

            for (int i=0; i<tournament.getPhases(); i++) {
                generateRoundMatches(matches, enrolled.stream().toList(), tournament, i);
            }

            tournament.setMatches(matches);
            tournamentRepository.save(tournament);
        }

        Optional<Tournament> OptTournament = Optional.of(tournament);
        return matchRepository.findAllByTournament(OptTournament);
    }

    private void generateRoundMatches(List<Match> matches, List<Team> teams,Tournament tournament, int phase) {
        Collections.shuffle(teams);
        int teamsNumber = 0;
        if(teams.size() % 2 == 0){
            teamsNumber = teams.size();
        } else {
            teamsNumber = teams.size()-1;
            matches.add(new Match(teams.get(teams.size()),1 , null, 0,phase ,tournament));
        }
        for (int i=0; i<teamsNumber; i=i+2){
            matches.add(new Match(teams.get(i),teams.get(i+1),phase ,tournament));
        }
    }
}
