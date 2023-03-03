package card.derived;


import game.logic.GameBoard;
import game.object.Card;
import game.object.Player;

public class MoveCard extends Card{

	public MoveCard(String name,int position) {
		super(name,position);
		this.type = "Move";
	}
	
	public void use(Player player) {
		if (this.getValue() - player.getPosition() < 0) {
			player.move(this.getValue() - player.getPosition() + 28);
		} else {
			player.move(this.getValue()-player.getPosition());
		}
		player.stepOnTile();
		
		
		if (this.getValue() == 7) {
			System.out.println("Feeling sick of social, live in the Island for 3 round!");
		} else if (this.getValue() == 14) {
			System.out.println("Feeling lucky, go straight to The airport!");
		} else if (this.getValue() == 21) {
			System.out.println("Feeling angry, let's go attack some people!");
		} else {
			System.out.println("Move unsuccessfully");
		}
		System.out.println(player.getName() + " is at position: " + player.getPosition());
	}
}
