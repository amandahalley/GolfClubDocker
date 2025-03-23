package com.keyin.rest.tournaments;

import com.keyin.rest.members.Member;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tournament")
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "tournament_sequence")
    private long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private double entryFee;
    private double cashPrize;

    @ManyToMany
    @JoinTable(
            name = "tournament_members",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )

    private List<Member> membersParticipating = new ArrayList<>(); //list of members participating in tournaments

    public Tournament() {

    }

    public Tournament(LocalDate startDate, LocalDate endDate, String location, double entryFee, double cashPrize) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
    }

    public long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    public List<Member> getMembersParticipating() {
        return membersParticipating;
    }

    public void addMember(Member member) {
        this.membersParticipating.add(member);
    }
}