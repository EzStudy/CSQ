# CSQ(Computer Science Quiz)

CS 봇

- CS 관련 문제를 풀 수 있는 챗봇입니다.


## 기능

### 사용자 챗봇문제 

- 받을 시간 설정 or 문제 받을 
- 주기 설정
- 원하는 문제 유형(카테고리) 설정
- 문의하기 (도움말)
- 문제 풀기
- 문제 해설 보기

### 관리자 챗봇

- 카테고리 만들기
- 문제 만들기
- 관리자 권한 부여하기
- 문의 조회
- 문의 내용에 답변 달기
  




**Quiz**

- 아이디(String) - uuid
- 카테고리(String)
- 문제(String)
- 객관식 보기1(String)
- 객관식 보기2(String)
- 객관식 보기3(String)
- 객관식 보기4(String)
- 객관식 보기5(String)
- 정답(String)
- 해설(String)
- 생성 일시 (timestamp)
- 업데이트 일시 (timestamp)




## 테이블

### Category

- 아이디(String) - uuid
- 이름 (String)
- 생성 일시 (timestamp)
- 업데이트 일시 (timestamp)



### User

- 아이디 (String) - uuid
- 이름 (String)
- 이메일 (String)
- 자동 문제 출제 여부 선택 (tinyint)
- 문제 받는 시간 (Integer) 0~23
- 권한 (사용자, 관리자)
- 생성 일시 (timestamp)
- 업데이트 일시 (timestamp)



### Question

- 아이디(String) – uuid
- 질문 제목 (String)
- 질문 내용 (String)
- 사용자 아이디 (String)
- 생성 일시 (timestamp)
- 업데이트 일시 (timestamp)



### Answer

- 아이디 (String) - uuid
- 답변 (String)
- 답변 시간 (Timestamp)
- 질문 아이디(String) – uuid
- 생성 일시 (timestamp)
- 업데이트 일시 (timestamp)



