package com.keyin.rest.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;


    public Member addMember(Member member) {
        System.out.println("MemberService: Saving member: " + member.getName());
        Member saved = memberRepository.save(member);
        System.out.println("Saved member ID: " + saved.getId());
        return saved;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(long id) {
        return memberRepository.findById(id);
    }

    public List<Member> searchMemberByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> searchMemberByPhoneNum(String phoneNumber) {
        return memberRepository.findByPhoneNumber(phoneNumber);
    }

    public List<Member> searchMemberByStartDate(String startDate) {
        return memberRepository.findByStartDate(startDate);
    }

    public void deleteMember(long id){
        memberRepository.deleteById(id);
    }
}