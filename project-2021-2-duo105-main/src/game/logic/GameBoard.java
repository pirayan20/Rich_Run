package game.logic;

import java.util.ArrayList;

import card.derived.MinusCard;
import card.derived.MoveCard;
import card.derived.PlusCard;
import game.object.Card;
import game.object.Player;
import game.object.Tile;
import player.logic.PlayerStage;
import tile.base.CardTile;
import tile.base.StartTile;
import tile.corner.AttackTile;
import tile.corner.IslandTile;
import tile.corner.PlaneTile;
import tile.normal.Deed;

public class GameBoard {
	
	public static int round = 1;
	public static int turn = 0;
	public static ArrayList<Card> deck = new ArrayList<Card>();
	public static ArrayList<Tile> tiles = new ArrayList<Tile>();
	public static ArrayList<Player> allPlayers = new ArrayList<Player>() ;
	private static String[] carreerList = new String[] {"Teacher","Psychiatrist","Dentist","Lawyer"
			,"Accountant","Pharmacist","Scientist","Artist","Architect"
			,"Veterinarian","Archeologist","Doctor","Police","Soldier",
			"Politician","Judge","Athlete","Director","Actor","Engineer"};
	public static GameBoardStage gameBoardStage;


	public static void initGame() {
		GameBoard.gameBoardStage = GameBoardStage.INIT;
		initDeck();
		initBoard();
	}
	
	public static void initTurn(Player player,int move) {
		if (!(player.getPlayerStage() == PlayerStage.ISLAND)) {
			player.move(move);
			player.stepOnTile();
		} else {
			System.out.println(player.getName()+ " is stucking in island");
		}
		
	}
	
	public static void updatePlayerStage() {
		for (Player player : GameBoard.allPlayers) {
			if (player.getPlayerStage() == PlayerStage.ISLAND) {
				if (player.island == 1) {
					player.setPlayerStage(PlayerStage.NORMAL);
				}
			}
		}
	}
	
	public static Card getRandomCardInDeck() {
		int i = (int)(Math.random()*deck.size());
		return deck.get(i);
	}
	
	public static void addStaticPlayer(Player player) {
		allPlayers.add(player);
	}
	
	public static void initDeck() {
		for (int i=1 ; i<5; i++) {
			deck.add(new PlusCard("Plus your money " + i*500 + " $",i*500));
			deck.add(new MinusCard("Minus your money " + i*500 + " $",i*500));
		}
		deck.add(new MoveCard("Go to Island",7));
		deck.add(new MoveCard("Go to Plane",14));
		deck.add(new MoveCard("Go to AttackTile",21));
	}
	
	public static int rollDice() {
		int x = (int)(Math.random()*6 + 1);
		System.out.println("dice result is " + x);
		return x;
	}
	
	public static void initBoard() {
		tiles.add(new StartTile());
		int c = 0;
		for (int i=1;i < 28;i++) {
			if (i == 7) {
				tiles.add(new IslandTile());
			} else if (i == 14) {
				tiles.add(new PlaneTile());
			} else if (i == 21) {
				tiles.add(new AttackTile());
			} else if (i == 4 || i == 9 || i == 18 || i == 23) {
				tiles.add(new CardTile());
			} else {
				tiles.add(new Deed(carreerList[c],i));
				c += 1;
			}
		}
	}
	
	public static Tile getTileInPosition(Player player) {
		return tiles.get(player.getPosition());
	}
	
	public static void getBoardCurrentRound() {
		System.out.println("------- Start of round "+ GameBoard.round + " --------");
	}
	
	public static Player getRandomPlayerInBoard() {
		int i = (int)(Math.random()*allPlayers.size());
		return allPlayers.get(i);
	}
}
