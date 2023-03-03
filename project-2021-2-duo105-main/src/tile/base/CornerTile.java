package tile.base;

import game.object.Tile;

public abstract class CornerTile extends Tile{
	
	protected String cornerTileType;

	//constructor
	public CornerTile() {
		
		this.tileType = "Corner"; 
	}
	
	//method
	public abstract void land();
	
	
	//getter & setter
	public String getCornerTileType() {
		return this.cornerTileType;
	}
}
