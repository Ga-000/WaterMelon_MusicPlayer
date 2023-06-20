# WaterMelon_MusicPlayer

This is a **music streaming site** called Watermelon.

## Requirement
For building and running the applicaion you need:
* eclipse
  * jdk1.8.0_361
* SQLdeveloper
* Scenebuilder-8.5.0

## 
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
    user_id VARCHAR2(80) not null,				     	   --외래키로 지정할 컬럼
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
user_id VARCHAR2(80) not null,                       --외래키로 지정할 컬럼
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
user_id VARCHAR2(80) not null,                       --외래키로 지정할 컬럼
    CONSTRAINT fk_user_id foreign key(user_id) references member (id)  --외래키 지정문
  --CONSTRAINT [FK명] foreign key([FK가 될 컬럼명]) references [PK가 위치하는 테이블] ([PK컬럼명])
);
```
