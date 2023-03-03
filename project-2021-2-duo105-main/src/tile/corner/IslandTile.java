package tile.corner;

import player.logic.PlayerStage;
import tile.base.CornerTile;

public class IslandTile extends CornerTile{

	public IslandTile() {
		
		this.cornerTileType = "Island";
	}
	
	public void land() {
		this.currentStepper.setPlayerStage(PlayerStage.ISLAND);
		System.out.println(this.currentStepper.getName() + " is waiting at Island");
	}
	
}
