package game.object;

public abstract class Card {
	
	private String name;
	private int value;
	protected String type;

	
	//Constructor
	public Card(String name,int value) {
		this.setName(name);
		this.setValue(value);
	}
	
	public abstract void use(Player player);

	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	//getter
	public int getValue() {
		return this.value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

}


