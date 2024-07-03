package com.jw.menumateapp.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.jw.menumateapp.dto.Member;

@Mapper
public interface MemberMapper {
	void SignUp(Member member);
}
