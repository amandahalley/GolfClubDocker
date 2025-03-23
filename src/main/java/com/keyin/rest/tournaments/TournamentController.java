package com.keyin.rest.tournaments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/tournaments")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    @PostMapping
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament) {
        return ResponseEntity.ok(tournamentService.addTournament(tournament));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        Optional<Tournament> tournament = tournamentService.getTournamentById(id);
        if(tournament.isPresent()) {
            return ResponseEntity.ok(tournament.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable Long id, @RequestBody Tournament updatedTournament) {
        Optional<Tournament> existingTournament = tournamentService.getTournamentById(id);
        if (existingTournament.isPresent()) {
            Tournament tournament = existingTournament.get();
            tournament.setStartDate(updatedTournament.getStartDate());
            tournament.setEndDate(updatedTournament.getEndDate());
            tournament.setLocation(updatedTournament.getLocation());
            tournament.setEntryFee(updatedTournament.getEntryFee());
            tournament.setCashPrize(updatedTournament.getCashPrize());
            return ResponseEntity.ok(tournamentService.addTournament(tournament));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{tournamentId}/addMember/{memberId}")
    public ResponseEntity<Tournament> addMemberToTournament(@PathVariable long tournamentId, @PathVariable long memberId) {
        return ResponseEntity.ok(tournamentService.addMemberToTournament(tournamentId, memberId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable long id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.noContent().build();
    }

}
