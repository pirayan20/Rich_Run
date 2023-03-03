package tile.normal;

import game.object.Player;
import tile.base.NormalTile;

public class House extends NormalTile{
	
	public House(String name, int position, int topay, int tobuy, Player owner) {
		// TODO Auto-generated constructor stub
		super(name,position);
		setOwner(owner);
		this.toPay = topay;
		this.toBuy = tobuy;
		this.normalTileType = "House";
	}

	@Override
	public void land() {
		if (this.currentStepper.getMoney() > this.getToPay()) {
			this.currentStepper.setMoney(this.currentStepper.getMoney() - this.getToPay());
			this.getOwner().setMoney(this.getOwner().getMoney() + this.getToPay());
		} else {
			System.out.println("Not enought money");
			this.currentStepper.setMoney(0);
		}
		System.out.println(this.currentStepper.getName() + " has arrived at " + this.name);
	}
	
	
	
}

