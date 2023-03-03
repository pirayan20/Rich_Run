package tile.corner;

import java.util.ArrayList;

import game.logic.GameBoard;
import game.object.Card;
import game.object.Player;
import tile.base.CornerTile;

public class AttackTile extends CornerTile{
	
	public AttackTile() {
		this.cornerTileType = "Attack";
	}
	
	public void land() {
		ArrayList<Player>temp = (ArrayList<Player>)GameBoard.allPlayers.clone();
		temp.remove(this.currentStepper);
		for (Player target : temp) {
			target.setMoney(target.getMoney() - 750);
			this.currentStepper.setMoney(this.currentStepper.getMoney() + 750);
		} 
		
	}
	
}
