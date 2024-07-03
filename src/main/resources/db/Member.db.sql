CREATE TABLE Member_MenuMateApp (
    userId VARCHAR2(50) PRIMARY KEY,         -- 아이디, 기본 키로 설정
    userPassword VARCHAR2(100) NOT NULL,     -- 비밀번호
    userName VARCHAR2(100) NOT NULL,         -- 이름
    phoneNumber VARCHAR2(15),                -- 전화번호
    birthdate DATE,                          -- 생년월일
    address VARCHAR2(255),                   -- 주소
    signupDate DATE DEFAULT SYSDATE          -- 가입년월일, 기본값은 현재 날짜
);

select * from  MEMBER_MENUMATEAPP;