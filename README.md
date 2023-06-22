# 🍉WaterMelon_MusicPlayer🎧
This is a **music streaming site** called 'WaterMelon'.

<br/>

## ⚙Requirement
For building and running the applicaion you need:
* `eclipse`
  * jdk1.8.0_361
  * JavaFX
* `SQLdeveloper`
* `Scenebuilder-8.5.0`
  * FXML

## 🎮기능
* 관리자 계정 로그인
	* 회원가입 창에서 '아이디 : system'으로 회원 가입
  	* 로그인 창에서 system계정으로 로그인할 경우, 관리자 창에서 음악 추가/삭제 가능, 회원리스트/음악리스트 볼 수 있음

* 로그인 / 비로그인 회원에 따라 보여지는 Main화면이 다름
	* 비로그인 회원 : Home, 인기차트, 최신음악
	* 회원 : Home, 인기차트, 최신음악, 재생목록, 플레이리스트

* Home
	* Main화면으로 홍보영상 재생
* 최신음악 
	* 관리자가 추가한 음악이 순서대로 나열되는 리스트
	* 가장 최근에 추가한 음악이 가장 위쪽에 배치
* 인기차트 
	* 회원이 누른 좋아요 개수를 많은 음악 순서대로 나열한 리스트
* 재생목록
	* 로그인 회원이 인기차트/최신음악에서 한번이라도 클릭한 음악을 나열한 리스트
* 플레이리스트
	* 로그인 회원이 직접 좋아하는 음악을 '+' 클릭을 통해 추가한 리스트

* 음악 재생 창
	* 음악재생버튼
		* 첫 번째 클릭 시, 음악을 불러오면서 재생바의 시간이 0:00 에서 각 음악의 전체 재생시간으로 변경
		* 두 번째 클릭 시, 음악 재생 
	* 좋아요 기능
		* 모든 회원이 음악 재생 창에서 '하트' 클릭을 통해 좋아요를 누름
	* 담기 기능
		* 로그인 회원이 직접 원하는 음악을 '+' 클릭을 통해 플레이 리스트에 추가
	* 음악 재생 바
		* 음악이 재생되는 과정/시간을 나타내는 슬라이드
		* 원하는 음악 재생 위치로 이동 가능


## 🎮Functions
* Administrator account login
	* Sign up as a member with 'ID: system' in the membership registration window
	* If you log in as a 'system' account, you can add/delete music and can see Member list / Music list in the Administrator window

* The main screen is different depending on the login / non-login member
	* Non-login members: Home, Popular musiclist, Recent musiclist
	* login members: Home, Popular musiclist, Recent musiclist, Musiclist, Playlist

* Home
	* Play promotional videos on the main screen
* Recent musiclist
	* List of music added by the administrator in order
	* Place most recently added music on top
* Popular musiclist
	* List of music according to the number of 'Like'
* Musiclist
	* List of music that a login member clicked once on a Recent musiclist/Popular musiclist
* Playlist
	* List of music that the login member has added by clicking on '+' button himself/herself

* Music Playback Window
	* Music play button
		* The first click changes the playback bar's time from 0:00 to the total playback time of each music
		* The second click, play music!!
	* Like button
		* Members click 'Heart' on the music they like in the music playback window
	* Add button
		* Add the music that the login member wants directly to the playlist by clicking '+'
* Progress bar
	* Progress bar showing when music is played
	* Move to the desired music playback location

<br/>

## 📁Code Package
* main 패키지
	> * startPage.fxml  :  로딩화면
	> * startPageController  :  로딩화면 controller
	
	> * Lmain.fxml : (로그인) main화면 메뉴바
	> * LChartController.java : main화면 메뉴바 controller
	> * Nmain.fxml : (비로그인) main화면 메뉴바
	> * NChartController.java : main화면 메뉴바 controller
	
	> * home.fxml  :  main화면 중간 내용
	> * homeController.java  :  main화면 중간 내용 controller
	> * musicPlay.fxml  :  음악 재생 창
	> * MusicPlayController.java  :  음악 재생 controller
	
	> * ChartDAO.java
	> * ChartDTO.java


* member 패키지
	> * login.fxml  :  로그인 창
	> * myUpdate.fxml  :  회원정보 수정 창
	> * register.fxml  :  회원가입  창
	> * memberController.java  :  로그인 창 controller
 
	> * myPage.fxml  :  마이페이지 창
	> * myPageController.java  :  마이페이지 controller
 
	> * loginDTO.java
	> * loginStaticDTO.java
	> * MemberDAO.java
	> * MemberDTO.java


* login 패키지 --- 로그인 후 화면
	> * Lpopular.fxml  :  (로그인) 인기 차트 페이지
	> * LpopularController.java  :  (로그인) 인기 차트 controller
	> * Lrecent.fxml  : (로그인) 최신 음악 페이지
	> * LrecentController.java  :  (로그인) 최신 음악 controller
	> * LplayList.fxml  :  (로그인) 플레이 리스트 페이지
	> * playlistController.java  : (로그인) 플레이 리스트 controller
	> * PlaytitleDTO.java  
	> * LmusicList.fxml  :  (로그인) 재생목록 페이지 
	> * MyplaylistController.java :  (로그인) 재생목록 controller
	> * MYplayListDTO.java 

* nonlogin 패키지 --- 로그인 전 화면
	> * Npopular.fxml  :  (로그인)인기 차트 페이지
	> * NpopularController.java  :  (로그인) 인기 차트 controller
	> * Nrecent.fxml  : (로그인) 최신 음악 페이지
	> * NrecentController.java  :  (로그인) 최신 음악 controller


* system 패키지 --- 관리자 화면
	> * SystemManagement.fxml  :  관리자 모드 페이지
	> * SystemController.java  :  관리자 모드 controller
	> * SystemManagement.css  
	> * SystemDAO.java
	> * SystemDTO.java

* common 패키지
	> * HMakeMusicBox.java  :  (인기차트) 재생 목록 리스트
	> * MakeMusicBox.java  :  (인기차트) 재생 목록 리스트
	> * MakeAlbumImage.java : 재생목록 음악 앨범이미지

<br/>

## 🧾DB Table
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

<br/>

# 🎞DEMO
### Demo Video : [WaterMelon DEMO.zip](https://github.com/Ga-000/WaterMelon_MusicPlayer/files/11805182/watermelon.zip)
### Demo Photo
![WaterMelon no.1](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/6ccb5029-d634-4b0f-9482-cccebb41bd7b)
![WaterMelon no.2](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/b70b8cfc-e201-4759-b9fc-3e5a3fb80f8f)
![WaterMelon no.3](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/4ac55851-3fd9-4adc-bd52-5ccd3ca07d74)
![WaterMelon no.4](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/adc535fb-ec9c-4c5d-bfbe-6926d80c304b)
![WaterMelon no.5](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/f85a0c0a-9c2a-4649-a5df-01b329f9bedb)
![WaterMelon no.6](https://github.com/Ga-000/WaterMelon_MusicPlayer/assets/134590236/812b02cb-c70a-4e01-aaa5-1e87420bf964)
