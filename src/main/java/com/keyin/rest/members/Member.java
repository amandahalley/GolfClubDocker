package com.keyin.rest.members;

import com.keyin.rest.tournaments.Tournament;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String address;

    private String email;

    private String phoneNumber;

    @Column(name = "start_date") // safe name for DB
    private String startDate;

    @Column(name = "membership_duration")
    private Integer membershipDuration;

    @ManyToMany(mappedBy = "membersParticipating")
    private List<Tournament> tournaments = new ArrayList<>();

    public Member() {
    }

    // optional: remove constructor altogether to avoid confusion

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(Integer membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void addTournament(Tournament tournament) {
        this.tournaments.add(tournament);
    }

}
