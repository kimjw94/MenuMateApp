package com.jw.menumateapp.home.dto;

import java.sql.Date;

public class SignupMemberDTO {
	private String memberId; // 회원번호 추가
	private String userId;
	private String userPassword;
	private String userName;
	private String phoneNumber;
	private Date birthdate;
	private String address;
	private Date signupDate;

	public SignupMemberDTO() {

	}

	public SignupMemberDTO(String memberId, String userId, String userPassword, String userName, String phoneNumber,
			Date birthdate, String address, Date signupDate) {
		super();
		this.memberId = memberId;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.birthdate = birthdate;
		this.address = address;
		this.signupDate = signupDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

}