package tile.corner;

import game.logic.GameBoard;
import game.object.Player;
import player.logic.PlayerStage;
import tile.base.CornerTile;

public class PlaneTile extends CornerTile{

	
	public PlaneTile() {
		this.cornerTileType = "Plane";
	}
	
	public void land() {
		Player target = GameBoard.getRandomPlayerInBoard();
		this.currentStepper.setMoney(this.currentStepper.getMoney() + 1000);
		target.setMoney(target.getMoney() - 1000);
		System.out.println(this.currentStepper.getName() + " are collecting ticket");
	}
	
	
}
