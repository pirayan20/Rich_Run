package GamePageFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import application.Main;
import game.logic.GameBoard;
import game.logic.GameBoardStage;
import game.object.Card;
import game.object.Player;
import game.object.Tile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import player.logic.PlayerStage;
import tile.base.CardTile;
import tile.base.CornerTile;
import tile.base.NormalTile;
import tile.normal.Deed;

	public class ControlGamePage implements Initializable{
		
		@FXML
		Button startButton, closeOptionButton;
		@FXML
		Button readRuleButton, continueButton;
		@FXML
		Button tile0,tile1,tile2,tile3,tile4,tile5,tile6,tile7,tile8,tile9,
		tile10,tile11,tile12,tile13,tile14,tile15,tile16,tile17,tile18,tile19,
		tile20,tile21,tile22,tile23,tile24,tile25,tile26,tile27;
		
		@FXML
		Text player1Name,player2Name,player3Name,player4Name;
		@FXML
		Text player1money,player2money,player3money,player4money;
		@FXML
		Text player1assets,player2assets,player3assets,player4assets;
		@FXML
		Text playerInTurn,round;
		
		@FXML
        ImageView optionButton, exitButton, soundButton;
		
		public static int actualPosition = 0;
		
		private ArrayList<Button> allTile = new ArrayList<Button>();
		private ArrayList<String> allColor = new ArrayList<String>();
		public void closeDice(ActionEvent event) throws IOException {
			Main.popUpStage.close();
		}
		
		public void isSongRunning(MouseEvent event) throws IOException{
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
		
	
		public void gotoOptionPopUp(MouseEvent event) throws IOException {
            Main.popUpStage = new Stage();
            Main.pop = FXMLLoader.load(getClass().getResource("/GamePageFXML/Option.fxml"));
            Main.popUpStage.setScene(new Scene(Main.pop));
            Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
            Main.popUpStage.initOwner(Main.stage);
            Main.popUpStage.setResizable(false);
            Main.popUpStage.setTitle("RICH AND RUN");
            Main.popUpStage.showAndWait();
        }
		
		public void goToMainPage(MouseEvent event) throws IOException {
            Main.root = FXMLLoader.load(getClass().getResource("/HomePageFXML/Home_Page.fxml"));
            Main.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Main.scene = new Scene(Main.root);
            Main.stage.setScene(Main.scene);
            Main.stage.setResizable(false);
            Main.stage.setTitle("RICH AND RUN");
            Main.stage.show();
        }
		
		public void goToPopUpReadRule(ActionEvent event) throws IOException {
			Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/HomePageFXML/ReadRule.fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait();
		}
		
		public void closePopUpOption(ActionEvent event) throws IOException {
			Main.popUpStage = (Stage) closeOptionButton.getScene().getWindow();
			Main.popUpStage.close();
		}
		
		public void popTeacher(ActionEvent event) throws IOException {
			Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/PopGameFXML/Teacher.fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait();
		}
		
		public void updateName() {
			player1Name.setText(GameBoard.allPlayers.get(0).getName().toUpperCase());
			player2Name.setText(GameBoard.allPlayers.get(1).getName().toUpperCase());
			if (GameBoard.allPlayers.size() == 3){
				player3Name.setText(GameBoard.allPlayers.get(2).getName().toUpperCase());
			} else if (GameBoard.allPlayers.size() == 4){
				player3Name.setText(GameBoard.allPlayers.get(2).getName().toUpperCase());
				player4Name.setText(GameBoard.allPlayers.get(3).getName().toUpperCase());
			} 
			
		}
		
		public void updateBoard() {
			startButton.setText("Roll Dice");
			playerInTurn.setText(GameBoard.allPlayers.get(GameBoard.turn).getName().toUpperCase()+ " 'S TURN");
			playerInTurn.setStyle("-fx-text-fill: " + allColor.get(GameBoard.turn));
			round.setText(GameBoard.round + "");
		}
		
		public void updateMoneyAndAssets() {
			player1money.setText(GameBoard.allPlayers.get(0).getMoney()+"");
			player1assets.setText(GameBoard.allPlayers.get(0).getAssets()+"");
			player2money.setText(GameBoard.allPlayers.get(1).getMoney()+"");
			player2assets.setText(GameBoard.allPlayers.get(1).getAssets()+"");
			if (GameBoard.allPlayers.size() == 3){
				player3assets.setText(GameBoard.allPlayers.get(2).getAssets()+"");
				player3money.setText(GameBoard.allPlayers.get(2).getMoney()+"");
			} else if (GameBoard.allPlayers.size() == 4) {
				player3assets.setText(GameBoard.allPlayers.get(2).getAssets()+"");
				player4assets.setText(GameBoard.allPlayers.get(3).getAssets()+"");
				player3money.setText(GameBoard.allPlayers.get(2).getMoney()+"");
				player4money.setText(GameBoard.allPlayers.get(3).getMoney()+"");
			} 
		}
		
		public int popUpDice()throws IOException  {
			int c = GameBoard.rollDice();
			Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/PopGameFXML/Dice" + c +".fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait();
			return c;
		}
		
		public void popAction(String name)throws IOException  {
			Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/PopGameFXML/"+name+".fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait();
		}
		
		public void popCard(String type, int value)throws IOException  {
			Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/PopGameFXML/"+ type + value +".fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait();
		}
		
		public void popIsland()throws IOException  {
			Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/PopGameFXML/Island.fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait();
		}
		
		public void popPlane()throws IOException  {
			Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/PopGameFXML/Plane.fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait();
		}
		
		public void popAttack()throws IOException  {
			Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/PopGameFXML/Attack.fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait();
		}
		
		public void popEndGame()throws IOException  {
			Main.popUpStage = new Stage();
			Main.pop = FXMLLoader.load(getClass().getResource("/GamePageFXML/EndGamePage.fxml"));
			Main.popUpStage.setScene(new Scene(Main.pop));
			Main.popUpStage.initModality(Modality.APPLICATION_MODAL);
			Main.popUpStage.initOwner(Main.stage);
			Main.popUpStage.setResizable(false);
			Main.popUpStage.setTitle("RICH AND RUN");
			Main.popUpStage.showAndWait();
		}
		
		public void initColor() {
			allColor.add("#1850e9;");
			allColor.add("#f53333;");
			allColor.add("#f3de01;");
			allColor.add("#00fd59;");
		}
		
		public void initTile() {
			allTile.add(tile0);
			allTile.add(tile1);
			allTile.add(tile2);
			allTile.add(tile3);
			allTile.add(tile4);
			allTile.add(tile5);
			allTile.add(tile6);
			allTile.add(tile7);
			allTile.add(tile8);
			allTile.add(tile9);
			allTile.add(tile10);
			allTile.add(tile11);
			allTile.add(tile12);
			allTile.add(tile13);
			allTile.add(tile14);
			allTile.add(tile15);
			allTile.add(tile16);
			allTile.add(tile17);
			allTile.add(tile18);
			allTile.add(tile19);
			allTile.add(tile20);
			allTile.add(tile21);
			allTile.add(tile22);
			allTile.add(tile23);
			allTile.add(tile24);
			allTile.add(tile25);
			allTile.add(tile26);
			allTile.add(tile27);
		}
		
		public void clearColor(int before,Tile tile) {
			if (tile.getAllStepper().size() == 0) {
				allTile.get(before).setId("playerNonPress");
			} else {
				int idx = GameBoard.allPlayers.indexOf(tile.getAllStepper().get(0));
				allTile.get(before).setId("player" + (idx+1) + "Press");
			}
		}
		
		public void updateRound() {
			GameBoard.turn = 0;
			GameBoard.round += 1;
			GameBoard.updatePlayerStage();
			GameBoard.getBoardCurrentRound();
		}
		
		public void startGame(ActionEvent event)throws IOException{
			if (GameBoard.gameBoardStage == GameBoardStage.INIT) {
				System.out.println("Amount of player in this game is " + GameBoard.allPlayers.size());
				initColor();
				initTile();
				updateName();
				updateBoard();
				updateMoneyAndAssets();
				GameBoard.getBoardCurrentRound();
				GameBoard.gameBoardStage = GameBoardStage.ROLLING;
				
			} else if (GameBoard.gameBoardStage == GameBoardStage.ROLLING) {
				
				ControlGamePage.actualPosition = 0;
				int c = popUpDice();
				Player playing = GameBoard.allPlayers.get(GameBoard.turn);
				System.out.println(playing.getName() + "'s turn");
				
				// In case there are multiple stepper
				// Not clearing the tile after the first stepper move
				int before = playing.getPosition();
				Tile tile = GameBoard.getTileInPosition(playing);
				tile.getAllStepper().remove(playing);
				clearColor(before,tile);		
				GameBoard.initTurn(playing,c);
				
				// move pass start tile
				if (before + c >= 28) {
					updateMoneyAndAssets();
					ControlGamePage.actualPosition = before + c - 28;
				} else {
					ControlGamePage.actualPosition = before + c;
				}

				// change a tile color when stepped
				allTile.get(ControlGamePage.actualPosition).setId("player" + (GameBoard.turn+1) +"Press");
				
				GameBoard.gameBoardStage = GameBoardStage.ACTION;
				startButton.setText("ACTION");
				
			} else if (GameBoard.gameBoardStage == GameBoardStage.ACTION){
				
				Player playing = GameBoard.allPlayers.get(GameBoard.turn);
				int position = playing.getPosition();
				Tile tile = GameBoard.getTileInPosition(playing);
				Tile actual = GameBoard.tiles.get(ControlGamePage.actualPosition);
				
				// action that will perform in any tile
				// step on NormalTile
				if (tile instanceof NormalTile) {
					NormalTile normal = (NormalTile)tile;
					popAction(normal.getName());
					if (!(Objects.isNull(normal.getOwner())) && normal.getToBuy() != 999999) {
						Deed deed = (Deed)normal;
						GameBoard.tiles.set(position, deed.upgradeTile());
						allTile.get(position).setStyle("-fx-border-color: "+ allColor.get(GameBoard.turn));
					}	
				// get a card then move to cornerTile
				} else if (!(actual.equals(tile)) && playing.island != 1){
					CardTile cardTile = (CardTile)actual;
					Card card = cardTile.getCardInTile();
					actual.getAllStepper().remove(playing);
					clearColor(ControlGamePage.actualPosition,actual);
					allTile.get(position).setId("player" + (GameBoard.turn+1) +"Press");
					popCard(card.getType(),card.getValue());
				// move to card tile by rolling	
				} else if (tile instanceof CardTile) {
					CardTile cardTile = (CardTile)tile;
					Card card = cardTile.getCardInTile();
					if (card.getType() != "Exchange") {
						popCard(card.getType(),card.getValue());
					}
				// islandTile
				} else if (playing.getPlayerStage() == PlayerStage.ISLAND) {
					popIsland();
				//	move to cornerTile by rolling
				} else if (tile.getTileType() == "Corner") {
					CornerTile corner = (CornerTile)tile;
					if (corner.getCornerTileType() == "Plane"){
						popPlane();
					} else if (corner.getCornerTileType() == "Attack"){
						popAttack();
					}
				} else {
					popCard("Plus",1000);
				}
				
				startButton.setText("END");
				updateMoneyAndAssets();
				GameBoard.gameBoardStage = GameBoardStage.ENDING;
				
			} else {
				GameBoard.turn += 1;
				if (!(GameBoard.turn < GameBoard.allPlayers.size())) {
					// finish each round
					updateRound();
				}		
				if (GameBoard.round < 11) {
					updateBoard();
					updateMoneyAndAssets();
					
					Player nextPlayer = GameBoard.allPlayers.get(GameBoard.turn);
					if (nextPlayer.getPlayerStage() == PlayerStage.ISLAND) {
						GameBoard.gameBoardStage = GameBoardStage.ACTION;
						nextPlayer.island += 1;
						startButton.setText("ACTION");
					} else {
						GameBoard.gameBoardStage = GameBoardStage.ROLLING;
						nextPlayer.setPlayerStage(PlayerStage.NORMAL);
						startButton.setText("Roll Dice");	
					}
				} else {
					popEndGame();
				}
			}
		}
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
		
}