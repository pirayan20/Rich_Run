package HomePageFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import game.logic.GameBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControlHomePage implements Initializable{
	
	//Home_Page
	@FXML
	Button choose2P, choose3P, choose4P, exitOptionButton;
	
	@FXML
	Button readRuleButton, continueButton;
	
	@FXML
	ImageView logOutButton, optionButtonm, soundButton;
	
	public void playMedia() {
		if (Main.running) {
			Main.mediaPlayer.pause();
			//soundButton.setImage(new Image(getClass().getResourceAsStream("/res/speakeroff.png")));
			Main.running = false;
		} else {
			Main.mediaPlayer.play();
			//soundButton.setImage(new Image(getClass().getResourceAsStream("/res/speakeron.png")));
			Main.running = true;
		}
	}
	
	public void goToEnterNamePage2P(ActionEvent event) throws IOException, InterruptedException{
		Main.root = FXMLLoader.load(getClass().getResource("/NamePageFXML/EnterName2P.fxml"));
        Main.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.scene = new Scene(Main.root);
        Main.stage.setScene(Main.scene);
        Main.stage.setResizable(false);
        Main.stage.setTitle("RICH AND RUN");
        Main.stage.show();
        GameBoard.initGame();
       }

	public void goToEnterNamePage3P(ActionEvent event) throws IOException, InterruptedException{
		Main.root = FXMLLoader.load(getClass().getResource("/NamePageFXML/EnterName3P.fxml"));
        Main.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.scene = new Scene(Main.root);
        Main.stage.setScene(Main.scene);
        Main.stage.setResizable(false);
        Main.stage.setTitle("RICH AND RUN");
        Main.stage.show();
        GameBoard.initGame();
       }
	
	public void goToEnterNamePage4P(ActionEvent event) throws IOException, InterruptedException{
		Main.root = FXMLLoader.load(getClass().getResource("/NamePageFXML/EnterName4P.fxml"));
        Main.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.scene = new Scene(Main.root);
        Main.stage.setScene(Main.scene);
        Main.stage.setResizable(false);
        Main.stage.setTitle("RICH AND RUN");
        Main.stage.show();
        GameBoard.initGame();
       }
	
	public void goToPopUpReadRule(ActionEvent event) throws IOException {
		Main.popUpStage = new Stage();
		Main.pop = FXMLLoader.load(getClass().getResource("/HomePageFXML/ReadRule.fxml"));
		Main.popUpStage.setScene(new Scene(Main.pop));
		Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
		Main.popUpStage.initOwner(Main.stage);
		Main.popUpStage.setResizable(false);
		Main.popUpStage.setTitle("READRULE");
		Main.popUpStage.showAndWait();
	}
	
	public void goToPopUpOption(MouseEvent event) throws IOException {
		Main.popUpStage = new Stage();
		Main.pop = FXMLLoader.load(getClass().getResource("/HomePageFXML/Option.fxml"));
		Main.popUpStage.setScene(new Scene(Main.pop));
		Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
		Main.popUpStage.initOwner(Main.stage);
		Main.popUpStage.setResizable(false);
		Main.popUpStage.setTitle("OPTION");
		Main.popUpStage.showAndWait();
	}
	
	public void closeApp(MouseEvent event) throws IOException {
		Main.root = FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
		Main.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Main.stage.close();
	}
	
	public void closePopUpOption(ActionEvent event) throws IOException {
		Main.popUpStage = (Stage) exitOptionButton.getScene().getWindow();
		Main.popUpStage.close();
	}
	
	public void closePopUpRule(ActionEvent event) throws IOException {
		Main.popUpStage = (Stage) continueButton.getScene().getWindow();
		Main.popUpStage.close();
	}
	
	public void isSongRunning(MouseEvent event) throws IOException{
		playMedia();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}