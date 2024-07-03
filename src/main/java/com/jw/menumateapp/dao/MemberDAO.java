package com.jw.menumateapp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.menumateapp.dto.Member;
import com.jw.menumateapp.mappers.MemberMapper;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	
	public void SignUp(Member m) {
		MemberMapper mapper = ss.getMapper(MemberMapper.class);
		
		mapper.SignUp(m);
	}
}
