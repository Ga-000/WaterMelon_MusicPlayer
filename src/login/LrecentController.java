package login;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.MakeMusicBox;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.ChartDAO;
import main.ChartDTO;
import main.MusicPlayController;
import member.LoginStaticDTO;

public class LrecentController implements Initializable {
	private ChartDAO Dao;
	private ArrayList<ChartDTO> musicList;
	private ObservableList<Node> fp;

	private File directorySongImg;
	private File[] fileSongImg;

	private ArrayList<File> songsImg;

	private String dbtitle;
	
	@FXML
	private FlowPane listPane;
	
	

	public void initialize(URL location, ResourceBundle resources) {
		Dao = new ChartDAO();
		MakeMusicBox MMB = new MakeMusicBox();
		MMB.setChartDAO(Dao);
		
		musicList = Dao.recentAll(); // oracle에서 음악 전체 리스트 가져오기.(정렬은 아직 안함.)
		fp = listPane.getChildren();
		for (ChartDTO dto : musicList) {
			String numStr = Integer.toString(dto.getNum());
			String singer = dto.getSinger();
			String dbtitle = dto.getTitle();
			fp.add(eachSong(numStr, singer, dbtitle));
		}
	}

	
	public Image musicPlay(String dbSinger, String dbTitle) {
		songsImg = new ArrayList<File>();
		directorySongImg = new File("musicAlbum");
		fileSongImg = directorySongImg.listFiles();
		
		if (fileSongImg != null) { // 폴더 노래가 없을 때까지 반복
			for (File file : fileSongImg) {
				songsImg.add(file);		
			}
		}
		
		for (File file : songsImg) {
			System.out.println("dbtitle"+dbtitle);
//			System.out.println(dbtitle.equals(file.getName()));
			
			String imgText = file.getName();
			String[] parts = imgText.split("-|\\."); // ("-")를 기준으로 문자열 분할

			String imgTitle = parts[1]; // 두 번째 제목 호출
//			String imgSinger = parts[0]; // 첫 번째 가수 호출
			if (dbtitle.equals(imgTitle)) {
				// 앨범 이미지 삽입
				System.out.println("if문 안"+file.getName());
				String albumURL = dbSinger + "-" + dbtitle + ".jpg";
				Image AlbumImage = new Image("/musicAlbum/" + albumURL);
		
				return AlbumImage;
			}
		}
		

		return null;
	}

	// 음악 리스트의 HBox하나 생성하기

	public HBox eachSong(String dbNum, String dbSinger, String dbTitle) {

		HBox songContainer = new HBox();
		songContainer.setPrefWidth(550.0);
		songContainer.setMaxHeight(50.0);
		songContainer.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		songContainer.setStyle("-fx-background-color: white;");

//		VBox numBox = new VBox();
//		numBox.setPrefSize(33.0, 50.0);
//		numBox.setAlignment(Pos.CENTER);
//		Label numLabel = new Label(dbNum);
//		numBox.getChildren().add(numLabel);

		VBox AlbumCoverBox = new VBox();
		AlbumCoverBox.setPrefSize(100.0, 200.0);
		AlbumCoverBox.setAlignment(Pos.CENTER);
//		ImageView coverImg = new ImageView(musicPlay(dbSinger, dbTitle));
	    ImageView coverImg = new  ImageView("musicAlbum/" + dbSinger + "-" + dbTitle + ".jpg");
		coverImg.setFitHeight(50);
		coverImg.setFitWidth(52);
		AlbumCoverBox.getChildren().add(coverImg);

		VBox songInfo = new VBox();
		songInfo.setPrefSize(297.0, 50.0);
		songInfo.setSpacing(5.0);
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
    		PlaytitleDTO pdto = new PlaytitleDTO ();
    		pdto.setTitle(dbTitle);
    		pdto.setSinger(dbSinger);
    		MusicPlayController mpc = new MusicPlayController();
//    		mpc.setPDTO(pdto);
    		String user_id = LoginStaticDTO.getId();
    		Dao.insertplaylist(dbTitle,dbSinger,user_id);
    		
    		//재생창 오픈
    		playOpen();
		};
		playBtn.setOnMouseClicked(play);

		songContainer.getChildren().addAll(AlbumCoverBox, songInfo, playBox);

		return songContainer;
	}
	
	private void playOpen() {
		FXMLLoader loadingPageLoader = new FXMLLoader(getClass().getResource("/main/musicPlay.fxml"));
		Stage primaryStage = new Stage();
		try {
			Parent loadingPage = loadingPageLoader.load();
			
			System.setProperty("prism.lcdtext", "false"); // 폰트파일 로드전에 실행(폰트 테두리 선명하게 = 안티앨러싱) 
			loadingPage.getStylesheets().add(getClass().getResource("/main/main.css").toExternalForm());
			
			primaryStage.setTitle("Music Play");
			primaryStage.setScene(new Scene(loadingPage));
	        primaryStage.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}