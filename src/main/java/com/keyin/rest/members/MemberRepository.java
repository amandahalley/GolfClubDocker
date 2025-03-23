package com.keyin.rest.members;

import com.keyin.rest.members.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long > {
    List<Member> findByName(String name);
    List<Member> findByPhoneNumber(String phoneNumber);
    List<Member> findByStartDate(String startDate);

}