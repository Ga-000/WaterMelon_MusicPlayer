package common;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import login.PlaytitleDTO;
import main.ChartDAO;
import main.ChartDTO;
import main.MusicPlayController;

public class HMakeMusicBox {

	/*
	 * 하트가 있는 노래 박스 만드는 class
	 * 
	 * 비로그인 인기차트(NpopularController), 로그인 인기차트(LpopularController)
	 */

	private MakeAlbumImage MAImage;
	public ChartDAO Dao;
	public ArrayList<ChartDTO> musicList;
	public MusicPlayController MPCon;
	

//	public void setPopularList(ArrayList<ChartDTO> musicList) { // 인기차트 목록 모두 불러오기
//		this.musicList = musicList;
//		
//	}

	public HMakeMusicBox() {
		MAImage = new MakeAlbumImage();
		MPCon = new MusicPlayController();
//		System.out.println("HMakeMusicBox ChartDAO" + Dao);
//		MPCon.setChartDAO(Dao);
//		System.out.println("musicList"+ musicList);
	}
	
	public void setChartDAO(ChartDAO Dao) {
		this.Dao = Dao;
	}

	public HBox eachSong(String dbSinger, String dbTitle, String heart, boolean plusButton) {

		HBox songContainer = new HBox();
		songContainer.setPrefWidth(550.0);
		songContainer.setMaxHeight(50.0);
		songContainer.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		songContainer.setStyle("-fx-background-color: white;");

		VBox heartBox = new VBox();
		heartBox.setPrefWidth(20);
		heartBox.setMaxHeight(100);
		heartBox.setAlignment(Pos.CENTER);
		ImageView heartImg = new ImageView("img/heartLine.png");
		heartImg.setFitHeight(24);
		heartImg.setFitWidth(29);
		Label likeCount = new Label(heart);
		heartBox.getChildren().addAll(heartImg, likeCount);

		VBox AlbumCoverBox = new VBox();
		AlbumCoverBox.setPrefSize(100.0, 200.0);
		AlbumCoverBox.setAlignment(Pos.CENTER);
		ImageView coverImg = new ImageView(MAImage.musicAlbum(dbSinger, dbTitle));
		coverImg.setFitHeight(50);
		coverImg.setFitWidth(52);
		AlbumCoverBox.getChildren().add(coverImg);

		VBox songInfo = new VBox();
		songInfo.setPrefSize(297.0, 50.0);
		songInfo.setSpacing(5.0);
		songInfo.setAlignment(Pos.CENTER_LEFT);
		String SongSinger = "";   // 노래 정보 정렬 출력
		String SongTitle = "";
		if(dbTitle.equals("그라데이션")) { SongSinger="10CM"; SongTitle="그라데이션"; }
		if(dbTitle.equals("낙하")) { SongSinger="AKMU (악뮤) (with 아이유)"; SongTitle="낙하"; }
		if(dbTitle.equals("LovesickGirls")) { SongSinger="BLACKPINK"; SongTitle="Lovesick Girls"; }
		if(dbTitle.equals("MyUniverse")) { SongSinger="Coldplay"; SongTitle="My Universe"; }
		if(dbTitle.equals("AfterLIKE")) { SongSinger="IVE (아이브)"; SongTitle="After LIKE"; }
		if(dbTitle.equals("WhenWillMyLifeBegin")) { SongSinger="Mandy Moore"; SongTitle="When Will My Life Begin"; }
		if(dbTitle.equals("Ditto")) { SongSinger="NewJeans"; SongTitle="Ditto"; }
		if(dbTitle.equals("나의X에게")) { SongSinger="경서"; SongTitle="나의 X에게"; }
		if(dbTitle.equals("선물")) { SongSinger="멜로망스"; SongTitle="선물"; }
		if(dbTitle.equals("야생화")) { SongSinger="박효신"; SongTitle="야생화"; }
		if(dbTitle.equals("밝게빛나는별이되어비춰줄게")) { SongSinger="송이한"; SongTitle="밝게 빛나는 별이 되어 비춰줄게"; }
		if(dbTitle.equals("strawberrymoon")) { SongSinger="아이유"; SongTitle="strawberry moon"; }
		if(dbTitle.equals("비와당신(슬기로운의사생활시즌2OSTPart1)")) { SongSinger="이무진"; SongTitle="비와 당신 (슬기로운 의사생활 시즌2 OST Part 1)"; }
		if(dbTitle.equals("신호등")) { SongSinger="이무진"; SongTitle="신호등"; }
		if(dbTitle.equals("Monologue")) { SongSinger="테이"; SongTitle="Monologue"; }
		if(dbTitle.equals("커피한잔할래요")) { SongSinger="폴킴"; SongTitle="커피 한 잔 할래요"; }
		Label title = new Label(SongTitle);
		Label singer = new Label(SongSinger);
		songInfo.getChildren().addAll(title, singer);

		VBox playBox = new VBox();
		ImageView playBtn = new ImageView("img/playButton.png");
		playBox.setPrefSize(51.0, 50.0);
		playBtn.setFitHeight(24.0);
		playBtn.setFitWidth(21.0);
		playBox.setAlignment(Pos.CENTER);
		playBox.getChildren().add(playBtn);

		EventHandler<Event> play = e -> {
			System.out.println("play 클릭");
			PlaytitleDTO pdto = new PlaytitleDTO();
			pdto.setTitle(dbTitle);
			pdto.setSinger(dbSinger);
			
//			MPCon.setPopularList(musicList);
//			System.out.println("HMakeMusicBox ChartDAO" + Dao);
			
//			MPCon.setChartDAO(Dao);
//		mpc.setPDTO(pdto);

			// 재생창 오픈
			playOpen();
		};
		playBtn.setOnMouseClicked(play);

		VBox AddSongBox = new VBox();
		ImageView addSongBtn = new ImageView("img/담기.png");
		AddSongBox.setPrefSize(51.0, 50.0);
		addSongBtn.setFitHeight(24.0);
		addSongBtn.setFitWidth(21.0);
		AddSongBox.setAlignment(Pos.CENTER);
		AddSongBox.getChildren().addAll(addSongBtn);
		AddSongBox.setVisible(plusButton);

		EventHandler<Event> myplaylist = e -> {
			System.out.println("담기 클릭");
			Dao.insertMYlist(dbTitle, dbSinger);
		};
		addSongBtn.setOnMouseClicked(myplaylist);

		songContainer.getChildren().addAll(heartBox, AlbumCoverBox, songInfo, playBox, AddSongBox);

		return songContainer;
	}

	private void playOpen() {
		FXMLLoader playPageLoader = new FXMLLoader(getClass().getResource("/main/musicPlay.fxml"));
		Stage primaryStage = new Stage();
		try {
			Parent playPage = playPageLoader.load();

			System.setProperty("prism.lcdtext", "false"); // 폰트파일 로드전에 실행(폰트 테두리 선명하게 = 안티앨러싱) 
			playPage.getStylesheets().add(getClass().getResource("/main/main.css").toExternalForm());
			
			MPCon = playPageLoader.getController();
//			MPCon.setChartDAO(Dao);
			primaryStage.setTitle("Music Play");
			primaryStage.setScene(new Scene(playPage));
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
