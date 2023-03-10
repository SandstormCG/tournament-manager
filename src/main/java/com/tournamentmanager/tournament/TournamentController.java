package com.tournamentmanager.tournament;


import com.tournamentmanager.match.Match;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="tournaments")
@AllArgsConstructor
public class TournamentController {

    private final TournamentService tournamentService;


    @RequestMapping(path="single-elimination/{tournamentId}")
    public List<Match> setSingleEliminationMatches(@PathVariable("tournamentId") Long tournamentId) {
        return tournamentService.generateSEMatches(tournamentId);
    }

}
