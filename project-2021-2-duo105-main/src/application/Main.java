package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static Stage stage;
	public static Scene scene;
	public static Parent root;
	
	public static Stage popUpStage;
	public static Scene popUpScene;
	public static Parent pop;
	
	private File directory;
	private File[] files;
	private ArrayList<File> songs;
	private int songNumber;
	private Media media;
	public static MediaPlayer mediaPlayer;
	public static boolean running;
	
	@Override
    public void start(Stage primaryStage) throws Exception {		
		try {
			root = FXMLLoader.load(getClass().getResource("/HomePageFXML/Home_Page.fxml"));
			//root.getStylesheets().add(getClass().getClassLoader().getResource("HomePageFXML/Home_Page.css").toString());
			primaryStage.setTitle("RUN AND RICH");
			primaryStage.setScene(new Scene(root));
			primaryStage.setResizable(false);
			primaryStage.show();
			addMusic();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void main(String[]args) {
		launch(args);
		
	}

	public void addMusic() {
        songs = new ArrayList<File>();
        directory = new File("music");
        files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                songs.add(file);
                System.out.println("BGM is playing !");
            }
        }
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }
	
}
