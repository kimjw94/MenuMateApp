package com.jw.menumateapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jw.menumateapp.dao.MemberDAO;
import com.jw.menumateapp.dto.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mDAO;
	
	@Transactional
	public void signUp(Member m) {
		mDAO.SignUp(m);
	}
}
