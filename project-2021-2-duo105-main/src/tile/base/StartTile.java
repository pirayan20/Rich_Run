package tile.base;

import game.object.Tile;

public class StartTile extends Tile{

	//constructor
	public StartTile() {
		this.tileType = "Start";
	}
	
	//method
	public void land() {
		this.currentStepper.setMoney(this.currentStepper.getMoney() + 1500);
	}
	
}
