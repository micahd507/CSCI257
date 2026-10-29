package game;

public class Officekey extends Item{
	private boolean usedKey;
	public Officekey() {
		super("officekey");
		usedKey = false;
	}
	@Override
	public void use() {
	if (Game.getCurrentRoom().getName().equals("Living Room")) {
		if (usedKey) {
			Game.print("You already opened the office door!");
		} else {
			Game.getCurrentRoom().getExit(1).setifOpen(true);
			usedKey = true;
			Game.print("Using the office key, you are able to…open the door. Are you proud"
					+ "you can put a key in a hole");
		}
	} else
		Game.print("You don't see any way to use the key…");
}
}