package com.jw.menumateapp.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jw.menumateapp.home.dao.MemberDAO;
import com.jw.menumateapp.home.dto.SignupMemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public void signUp(SignupMemberDTO signupMemberDTO) {
		try {

			// 비밀번호 Spring security의 bCryptPasswordEncoder 통해 암호화
			String encodedPassword = bCryptPasswordEncoder.encode(signupMemberDTO.getUserPassword());
			signupMemberDTO.setUserPassword(encodedPassword);

			// memberId 생성 및 포맷 후 저장
			int memberId = mDAO.getNextMemberId();
			String formmattedMemberId = String.format("%08d", memberId);
			signupMemberDTO.setMemberId(formmattedMemberId);

			mDAO.SignUp(signupMemberDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
