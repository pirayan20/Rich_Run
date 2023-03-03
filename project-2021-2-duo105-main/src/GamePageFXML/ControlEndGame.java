package GamePageFXML;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

import application.Main;
import game.logic.GameBoard;
import game.object.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControlEndGame implements Initializable{

	@FXML
	Text player1Name,player2Name,player3Name,player4Name;
	@FXML
	Text player1Money,player2Money,player3Money,player4Money;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		GameBoard.allPlayers.sort((Player p1, Player p2) -> {
			   if (p1.getMoney() + p1.getAssets() < p2.getMoney() + p2.getAssets())
			     return 1;
			   if (p1.getMoney() + p1.getAssets() > p2.getMoney() + p2.getAssets())
			     return -1;
			   return 0;
			});
		
		player1Name.setText(GameBoard.allPlayers.get(0).getName().toUpperCase());
		player1Money.setText((int)(GameBoard.allPlayers.get(0).getMoney() 
				+ GameBoard.allPlayers.get(0).getAssets()) + "");
		player2Name.setText(GameBoard.allPlayers.get(1).getName().toUpperCase());
		player2Money.setText((int)(GameBoard.allPlayers.get(1).getMoney() 
				+ GameBoard.allPlayers.get(1).getAssets()) + "");
		
		if (GameBoard.allPlayers.size() > 2) {
			player3Name.setText(GameBoard.allPlayers.get(2).getName().toUpperCase());
			player3Money.setText((int)(GameBoard.allPlayers.get(2).getMoney() 
					+ GameBoard.allPlayers.get(2).getAssets()) + "");
		} else {
			player3Name.setText(" - ");
			player3Money.setText(" - ");
			player4Name.setText(" - ");
			player4Money.setText(" - ");
		}
		if (GameBoard.allPlayers.size() == 4) {
			player4Name.setText(GameBoard.allPlayers.get(3).getName().toUpperCase());
			player4Money.setText((int)(GameBoard.allPlayers.get(3).getMoney() 
					+ GameBoard.allPlayers.get(3).getAssets()) + "");
		} else {
			player4Name.setText(" - ");
			player4Money.setText(" - ");
		}
	}
	
	
}
