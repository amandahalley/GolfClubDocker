package com.keyin.rest.members;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;



    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        System.out.println("MemberController: Received member: " + member.getName());
        return ResponseEntity.ok(memberService.addMember(member));
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable long id) {
        Optional<Member> member = memberService.getMemberById(id);
        if (member.isPresent()) {
            return ResponseEntity.ok(member.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable long id, @RequestBody Member updatedMember) {
        Optional<Member> existingMember = memberService.getMemberById(id);
        if (existingMember.isPresent()) {
            Member member = existingMember.get();
            member.setName(updatedMember.getName());
            member.setAddress(updatedMember.getAddress());
            member.setEmail(updatedMember.getEmail());
            member.setPhoneNumber(updatedMember.getPhoneNumber());
            member.setStartDate(updatedMember.getStartDate());
            member.setMembershipDuration(updatedMember.getMembershipDuration());
            return ResponseEntity.ok(memberService.addMember(member));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Member>> searchMembers(@RequestParam(required = false) String name,
                                                      @RequestParam(required = false) String phoneNumber,
                                                      @RequestParam(required = false) String startDate) {
        if (name != null) {
            return ResponseEntity.ok(memberService.searchMemberByName(name));
        } else if (phoneNumber != null) {
            return ResponseEntity.ok(memberService.searchMemberByPhoneNum(phoneNumber));
        } else if (startDate != null) {
            return ResponseEntity.ok(memberService.searchMemberByStartDate(startDate));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}