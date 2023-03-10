package com.tournamentmanager.match;

import com.tournamentmanager.tournament.Tournament;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> findAllByTournament(Optional<Tournament> tournamentId);



}

