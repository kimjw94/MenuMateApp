
--멤버 메뉴 메이트 어플

CREATE TABLE Member_MenuMateApp (
    memberId VARCHAR2(50) PRIMARY KEY,             -- 회원번호, 기본 키로 설정
    userId VARCHAR2(50) UNIQUE NOT NULL,     -- 아이디, 고유값으로 설정
    userPassword VARCHAR2(100) NOT NULL,     -- 비밀번호
    userName VARCHAR2(100) NOT NULL,         -- 이름
    phoneNumber VARCHAR2(15),                -- 전화번호
    birthdate DATE,                          -- 생년월일
    address VARCHAR2(255),                   -- 주소
    signupDate DATE DEFAULT SYSDATE          -- 가입년월일, 기본값은 현재 날짜
);

select * from  MEMBER_MENUMATEAPP;

CREATE SEQUENCE memberId_seq;

drop table MEMBER_MENUMATEAPP cascade constraint;
DROP SEQUENCE MEMBERID_SEQ;



