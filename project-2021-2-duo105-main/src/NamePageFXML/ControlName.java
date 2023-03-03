package NamePageFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import application.Main;
import game.logic.GameBoard;
import game.object.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import game.logic.GameBoard;

public class ControlName  implements Initializable{
	
	@FXML
	TextField player1name,player2name,player3name,player4name;
	
	@FXML
	Button backButton, confirmButton, closeButton;
	
	public boolean checkPlayerName() {
		for (Player player : GameBoard.allPlayers) {
			if (player.getName().equals("")) {
				return false;
			}
		}return true;
	}
	
	public void goToHomePage(ActionEvent event) throws IOException, InterruptedException{
		Main.root = FXMLLoader.load(getClass().getResource("/HomePageFXML/Home_Page.fxml"));
        Main.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.scene = new Scene(Main.root);
        Main.stage.setScene(Main.scene);
        Main.stage.setResizable(false);
        Main.stage.setTitle("RICH AND RUN");
        Main.stage.show();
	}

	public void closePopUpOption(ActionEvent event) throws IOException {
		Main.popUpStage = (Stage) closeButton.getScene().getWindow();
		Main.popUpStage.close();
	}
	
	public void goToGamePage(ActionEvent event) throws IOException, InterruptedException{
		this.getPlayer();
		if (checkPlayerName()) {
			int x = GameBoard.allPlayers.size();
			Main.root = FXMLLoader.load(getClass().getResource("/GamePageFXML/GamePage"+x+ "P.fxml"));
			Main.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Main.scene = new Scene(Main.root);
			Main.stage.setScene(Main.scene);
			Main.stage.setResizable(false);
			Main.stage.setTitle("RICH AND RUN");
			Main.stage.show();
      } else {
    	  	Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/NamePageFXML/requireTextField.fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait(); 
      }
	}
	public void getPlayer() {
		GameBoard.allPlayers = new ArrayList<Player>();
		Player player1 = new Player(player1name.getText());
		Player player2 = new Player(player2name.getText());
		if (!Objects.isNull(player3name)) {
			Player player3 = new Player(player3name.getText());
		} 
		if (!Objects.isNull(player4name)) {
			Player player4 = new Player(player4name.getText());
		}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
