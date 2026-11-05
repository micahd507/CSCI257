package game;

public class notebook extends Item{
	private boolean isRead;
	private boolean inStorage;
	public notebook() {
		super("notebook");
		isRead = false;
		inStorage = false;
	}
	public void read() {
		for(Item n: Game.Storage) {
			if(n.getItem().equals("notebook"));
				inStorage = true;
		}
	if(inStorage) {
		if(!isRead) {
			Game.print("You read the notebook, the safe password is 1234");
			Item password = new Item("password");
			Game.Storage.add(password);
		}else {
			Game.print("You read the notebook, the safe password is 1234");
		}
	}else {
		Game.print("There is nothing to read. Get to looking.");
	}
		
	}
	
}
