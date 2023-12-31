package com.example.purebasketconsumer.domain.member;

import com.example.purebasketconsumer.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m.email from Member m ")
    List<String> findAllEmails();
}
