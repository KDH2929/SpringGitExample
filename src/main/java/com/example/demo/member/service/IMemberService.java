package com.example.demo.member.service;

import com.example.demo.member.model.Member;

import java.util.List;

public interface IMemberService {
    void insertMember(Member member);
    Member selectMember(String userid);
    List<Member> selectAllMembers();
    void updateMember(Member member);
    void deleteMember(Member member);
    String getPassword(String userid);
}
