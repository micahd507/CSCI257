package game;

public class Tool extends Item{
		private boolean usedTool;
		public Tool() {
			super("tool");
			usedTool = false;
		}
		@Override
		public void use() {
		if (Game.getCurrentRoom().getName().equals("Bedroom")) {
			if (usedTool) {
				Game.print("You already opened the attic door!");
			} else {
				Game.getCurrentRoom().getExit(4).setifOpen(true);
				usedTool = true;
				Game.print("Using the tool, you are able to…open dat shit");
			}
		} else
			Game.print("You don't see any way to use the tool…");
	}
}