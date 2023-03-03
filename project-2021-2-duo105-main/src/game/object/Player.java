package game.object;

import java.util.ArrayList;

import game.logic.GameBoard;
import player.logic.PlayerStage;
import tile.base.NormalTile;

public class Player {

	private String name;
	private int assets;
	private int money;
	private int position;
	private PlayerStage playerStage;
	public int island = 0;

	public Player(String name) {
		this.name = name;
		initPlayer();
		GameBoard.addStaticPlayer(this);
	}

	public void initPlayer() {
		setMoney(5000);
		setAssets(0);
		setPosition(0);
		this.playerStage = PlayerStage.NORMAL;

	}

	public void move(int dice) {
		if (this.position + dice < 28) {
			setPosition(this.position + dice);
		} else {
			this.setMoney(this.getMoney() + 1000);
			setPosition(this.position + dice - 28);
		}
	}

	public void stepOnTile() {
		Tile tile = GameBoard.getTileInPosition(this);
		tile.setCurrentStepper(this);
		tile.allStepper.add(this);
		tile.land();
	}

	// setter
	public void setAssets(int asset) {
		this.assets = asset;
	}

	public void setMoney(int money) {
		if (money < 0) {
			money = 0;
		}
		this.money = money;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setPlayerStage(PlayerStage stage) {
		this.playerStage = stage;
	}

	// getter
	public String getName() {
		return this.name;
	}

	public int getAssets() {
		return this.assets;
	}

	public int getMoney() {
		return this.money;
	}

	public int getPosition() {
		return this.position;
	}

	public PlayerStage getPlayerStage() {
		return this.playerStage;
	}

}
