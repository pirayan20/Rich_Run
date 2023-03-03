package tile.base;

import java.util.Objects;

import game.logic.GameBoard;
import game.object.Card;

import game.object.Tile;

public class CardTile extends Tile{
	
	private Card randomed;
	
	//constructor
	public CardTile() {
		this.tileType = "Card";	
		
	}
	
	//method
	public void land() {
		Card card = GameBoard.getRandomCardInDeck();
		this.randomed = card;
		card.use(this.currentStepper);	
	}
	
	public Card getCardInTile() {
		return this.randomed;
	}
	
	
	
	
}
