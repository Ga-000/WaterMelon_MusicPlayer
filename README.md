# WaterMelon_MusicPlayer

This is a **music streaming site** called Watermelon.

<br/><br/>
## Programming Language

<br/>
## Requirement
For building and running the applicaion you need:
* `eclipse`
  * `jdk1.8.0_361`
  * `JavaFX`
* `SQLdeveloper`
* `Scenebuilder-8.5.0`

<br/>
## DB Table
```SQL
// 회원리스트 Table
CREATE TABLE member(
    id varchar2(20),
    pw varchar2(20),
    name varchar2(21),
    age varchar2(21),
    memberday varchar2(40),
    PRIMARY KEY(id)
);

// 음악리스트 Table
CREATE TABLE musicList(
 num int generated always as IDENTITY,
 heart NUMBER,
 singer VARCHAR2(30), 
 title VARCHAR2(80) not null, 
 user_id VARCHAR2(80) not null,				     	        --외래키로 지정할 컬럼
     CONSTRAINT mL_user_id foreign key(user_id) references member (id)  --외래키 지정문
   --CONSTRAINT [FK명] foreign key([FK가 될 컬럼명]) references [PK가 위치하는 테이블] ([PK컬럼명])
   ON DELETE CASCADE
);

// 관리자용 음악 테이블
CREATE TABLE System_musicList(
 num int generated always as IDENTITY,
 heart NUMBER,
 singer VARCHAR2(30) not null,
 title VARCHAR2(80) not null
);

// 사용자용 음악 테이블
CREATE TABLE User_musicList(
 num int generated always as IDENTITY,
 heart NUMBER,
 singer VARCHAR2(30) not null,
 title VARCHAR2(80) not null,
 user_id VARCHAR2(80) not null,                                               --외래키로 지정할 컬럼
     CONSTRAINT userlist_user_id foreign key(user_id) references member (id)  --외래키 지정문
   --CONSTRAINT [FK명] foreign key([FK가 될 컬럼명]) references [PK가 위치하는 테이블] ([PK컬럼명])
   ON DELETE CASCADE
);

// MYmusicList 테이블
CREATE TABLE MYmusicList(
 num int generated always as IDENTITY,
 heart NUMBER,
 singer VARCHAR2(30), 
 title VARCHAR2(80) not null, 
 user_id VARCHAR2(80) not null,                                         --외래키로 지정할 컬럼
     CONSTRAINT fk_user_id foreign key(user_id) references member (id)  --외래키 지정문
   --CONSTRAINT [FK명] foreign key([FK가 될 컬럼명]) references [PK가 위치하는 테이블] ([PK컬럼명])
);
```

<br/><br/>
# DEMO
### Demo Video : [WaterMelon DEMO.zip](https://github.com/Ga-000/WaterMelon_MusicPlayer/files/11805182/watermelon.zip)
### Demo Photo
![WaterMelon no.1](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/6ccb5029-d634-4b0f-9482-cccebb41bd7b)
![WaterMelon no.2](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/b70b8cfc-e201-4759-b9fc-3e5a3fb80f8f)
![WaterMelon no.3](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/4ac55851-3fd9-4adc-bd52-5ccd3ca07d74)
![WaterMelon no.4](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/adc535fb-ec9c-4c5d-bfbe-6926d80c304b)
![WaterMelon no.5](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/f85a0c0a-9c2a-4649-a5df-01b329f9bedb)
![WaterMelon no.6](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/812b02cb-c70a-4e01-aaa5-1e87420bf964)

