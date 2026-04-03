package com.example.demo.member.dao;

import com.example.demo.member.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMemberRepository {
    void insertMember(Member member);
    Member selectMember(String userid);
    List<Member> selectAllMembers();
    void updateMember(Member member);
    void deleteMember(Member member);
    String getPassword(String userid);
}
