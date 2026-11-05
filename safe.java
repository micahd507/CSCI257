package game;

public class safe extends Item{
	private boolean isOpen;
	private boolean isEmpty;
	
	public safe() {
		super("safe");
		isOpen = false;
		isEmpty = false;
	}
	@Override
	public void open() {
		if(!isOpen) {
			if(!isEmpty) {
				Game.print("You open the safe and find a notebook!");
				Item notebook = new notebook();
				Game.getCurrentRoom().setItem("notebook",notebook);
				isEmpty = false;
				isOpen = true;
			}else {
				Game.print("You open the safe back up and find nothing. Who knows, if you keep checking something may appear!\nIm joking please dont.");
				isOpen = true;
			}
		}else {
			Game.print("The safe is already open, cant you SEE that");
		}
	}
	@Override
	public void close() {
		if(isOpen) {
			Game.print("Look at you being considerate.\nYou close the safe");
			isOpen = false;
		}else {
			Game.print("The safe is already closed");
		}
	}
}
