package com.jw.menumateapp.home.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.jw.menumateapp.home.dto.SignupMemberDTO;

@Mapper
public interface MemberMapper {
	void SignUp(SignupMemberDTO signupMemberDTO);
	int getNextMemberId();
	
}
