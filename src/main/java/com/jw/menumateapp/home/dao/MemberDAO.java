package com.jw.menumateapp.home.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.menumateapp.home.dto.SignupMemberDTO;
import com.jw.menumateapp.home.mappers.MemberMapper;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	
	public void SignUp(SignupMemberDTO signupMemberDTO) {
		MemberMapper mapper = ss.getMapper(MemberMapper.class);
		
		mapper.SignUp(signupMemberDTO);
	}
	
	public int getNextMemberId() {
		MemberMapper mapper= ss.getMapper(MemberMapper.class);
		return mapper.getNextMemberId();
	}
	
}
