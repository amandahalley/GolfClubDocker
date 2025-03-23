package com.keyin.rest.tournaments;

import com.keyin.rest.members.Member;
import com.keyin.rest.members.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    @Autowired
    private com.keyin.rest.Tournaments.TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;


    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(long id) {
        return tournamentRepository.findById(id);
    }

    public List<Tournament> searchTournamentByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public List<Tournament> getTournamentByMemberId(long memberId) {
        return tournamentRepository.findByMembersParticipating_Id(memberId);
    }

    public Tournament addMemberToTournament(long tournamentId, long memberId) {
        Optional<Tournament> tournamentOpt = tournamentRepository.findById(tournamentId);
        Optional<Member> memberOpt = memberRepository.findById(memberId);

        if (tournamentOpt.isPresent() && memberOpt.isPresent()) {
            Tournament tournament = tournamentOpt.get();
            tournament.getMembersParticipating().add(memberOpt.get());
            return tournamentRepository.save(tournament);
        }
        throw new RuntimeException("Tournament or Member not found.");
    }

    public void deleteTournament(long id) {
        tournamentRepository.deleteById(id);
    }
}
