package card.derived;


import game.object.Card;
import game.object.Player;

public class PlusCard extends Card{
	
	public PlusCard(String name,int plus) {
		super(name,plus);
		this.type = "Plus";
	}
	
	public void use(Player player) {
		player.setMoney(player.getMoney() + this.getValue());
		System.out.println(player.getName() + " just won a lottery (gained " + this.getValue() + "$)");
	}
	
}
