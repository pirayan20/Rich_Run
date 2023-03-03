package game.object;

import java.util.ArrayList;

public abstract class Tile {
	
	protected String tileType;
	protected Player currentStepper = null;
	protected ArrayList<Player>allStepper = new ArrayList<Player>();
	
	public abstract void land();
	
	public String getTileType() {
		return this.tileType;
	}
	
	public void setCurrentStepper(Player stepper) {
		this.currentStepper = stepper;
	}
	
	public Player getCurrentStepper() {
		return this.currentStepper;
	}
	
	public ArrayList<Player> getAllStepper(){
		return this.allStepper;
	}
}
