package tile.base;

import game.object.Player;
import game.object.Tile;

public abstract class NormalTile extends Tile{
	
	
	public String name;
	public int position;
	
	private Player owner = null;
	
	protected int toBuy;
	protected int toPay;
	protected String normalTileType;
	
	//constructor
	public NormalTile(String name,int position) {
		this.name = name;
		this.position = position;
		this.tileType = "Normal";
	}
	
	//method
	public abstract void land();
	
	//getter & setter
	public String getName() {
		return this.name;
	}
	
	public String getNormalTileType() {
		return this.normalTileType;
	}
	
	public int getToBuy() {
		return this.toBuy;
	}
	
	public int getToPay() {
		return this.toPay;
	}
	
	public Player getOwner() {
		return this.owner;
	}
	
	public void setOwner(Player player) {
		this.owner = player;
	}
	

		
	
}
