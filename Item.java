package game;

import java.io.Serializable;

public class Item implements Serializable {
	private String item_name =  "";
	private boolean isHeavy;
	public Item(String name) {
		item_name = name;
		isHeavy = false;
	}
	public String getItem() {
		return item_name;
	}
	public void setItem(String name) {
		item_name = name;
	}
	public String toString() {
		String s = item_name;
		return s;
	}
	public boolean isheavy() {
		return isHeavy;
	}
	public void setweight(boolean weight) {
		isHeavy = weight;
	}
	public void use() {
		Game.print("You really thought that would work?"
				+ "Genually a skill issue");
		
	}
}
