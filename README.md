# 미美취라

능동적이고 활동적인 취미 공유 플랫폼

![image](https://user-images.githubusercontent.com/82012938/145270306-20f9f9f4-6719-433a-bdc7-8d5bb9bb44d3.png)


### 개발 환경
- Java 8
- MySQL, Workbench
- Spring Boot, JPA, Spring Security, RESTful API
- Mustache, HTML5, CSS3, Bootstrap
- VS code, IntelliJ
- Win 10
- Git, SourceTree

### 구현 기능
- 소셜 로그인, user 조회
- 모임 게시판(리스트, 조회, 수정, 삭제, 페이징, 검색)
- 자유 게시판(리스트, 조회, 수정, 삭제, 페이징, 검색)

### Database 생성
```MySQL
# root 
create database community default character set utf8;
show databases;
create user 'comm'@'%' identified by 'comm';
grant all privileges on community.* to 'comm'@'%';
```

### 설정 파일
`main > resources > application.properties`
```javascript
# DB 연동
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/community?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul
spring.datasource.username=comm
spring.datasource.password=comm
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true

# OAuth2 설정
spring.profiles.include=oauth
```
`main > resources > application-oauth.properties`
```javascript
spring.security.oauth2.client.registration.google.client-id=893649820392-ak1tc5vv7ssvqamptkmgt42bm4m8rae0.apps.googleusercontent.com
spring.security.oauth2.client.registration.google.client-secret=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
spring.security.oauth2.client.registration.google.scope=profile, email

# NAVER registration
spring.security.oauth2.client.registration.naver.client-id=00VfCm_xAMIpmiAnZEhS
spring.security.oauth2.client.registration.naver.client-secret=zcnzQD7xNX
spring.security.oauth2.client.registration.naver.redirect-uri={baseUrl}/{action}/oauth2/code/{registrationId}
spring.security.oauth2.client.registration.naver.authorization-grant-type=authorization_code
spring.security.oauth2.client.registration.naver.scope=name, email, profile_image
spring.security.oauth2.client.registration.naver.client-name=Naver

# NAVER provider
spring.security.oauth2.client.provider.naver.authorization-uri=https://nid.naver.com/oauth2.0/authorize
spring.security.oauth2.client.provider.naver.token-uri=https://nid.naver.com/oauth2.0/token
spring.security.oauth2.client.provider.naver.user-info-uri=https://openapi.naver.com/v1/nid/me
spring.security.oauth2.client.provider.naver.user-name-attribute=response

# KAKAO registration
spring.security.oauth2.client.registration.kakao.client-id=7975d2033d24fbc8354a4d73e8e12962
spring.security.oauth2.client.registration.kakao.client-secret=OdbdVAHFWA7UQbRn9QA58MOQLMgVrhpM
spring.security.oauth2.client.registration.kakao.redirect-uri={baseUrl}/{action}/oauth2/code/{registrationId}
spring.security.oauth2.client.registration.kakao.client-authentication-method=POST
spring.security.oauth2.client.registration.kakao.authorization-grant-type=authorization_code
spring.security.oauth2.client.registration.kakao.scope=profile_nickname, profile_image, account_email
spring.security.oauth2.client.registration.kakao.client-name=Kakao

# KAKAO Provider
spring.security.oauth2.client.provider.kakao.authorization-uri=https://kauth.kakao.com/oauth/authorize
spring.security.oauth2.client.provider.kakao.token-uri=https://kauth.kakao.com/oauth/token
spring.security.oauth2.client.provider.kakao.user-info-uri=https://kapi.kakao.com/v2/user/me
spring.security.oauth2.client.provider.kakao.user-name-attribute=id
```


