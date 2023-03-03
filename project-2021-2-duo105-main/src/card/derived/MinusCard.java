package card.derived;


import game.object.Card;
import game.object.Player;

public class MinusCard extends Card{
	
	
	public MinusCard(String name,int minus) {
		super(name,minus);
		this.type = "Minus";
	}
	
	public void use(Player player) {
		player.setMoney(player.getMoney() - this.getValue());
		System.out.println(player.getName() + " is having a bad luck (lose " + this.getValue() + "$)");
	}
}
