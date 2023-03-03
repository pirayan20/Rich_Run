package tile.normal;

import game.logic.GameBoard;
import tile.base.NormalTile;

public class Deed extends NormalTile{
		
	public Deed(String name,int position) {
		super(name,position);
		this.toBuy = this.position*100;
		this.normalTileType = "Deed";
		this.toPay = 0;
	}
	
	public House upgradeTile() {
		House house = new House
				(this.name,this.position,(int)(this.toBuy*1.4),999999,this.getOwner());
		return house;
	}
	
	@Override
	public void land() {
		if (this.currentStepper.getMoney() > this.getToBuy()) {
			this.setOwner(currentStepper);
			this.currentStepper.setMoney(this.currentStepper.getMoney() - this.getToBuy());
			this.currentStepper.setAssets(this.currentStepper.getAssets() + (int)(this.getToBuy()*1.1));
		}
		System.out.println(this.currentStepper.getName() + " has arrived at " + this.name);
	}
	
}

