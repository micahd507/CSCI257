package game;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room implements Serializable {
	private String Name = "";
	private boolean isOpen = true;
	//private String Description = "";
	private Room [] Directions;
	//private Item item= null;
	private Map<String, Item> item = new HashMap<>();
	private static Map<String, Room> save = new HashMap<>();
	public Room (String n, String p ) {
		Name = n; //NAME OF ROOM
		//Description = p; // DESCRIBES ROOM 
		Directions = new Room[6];
		Item[] item = {};
		save.put(Name, this);
		
	}

	public String toString() {
		String s = "" + Name;
		s += "\n\n"+Game.rooms.get(Name);
	return s;
	}
//	public void setName(String n){
//		Name = n;
//	}
//	public void setDes(String p) {
//		Description = p;
//	}
	public void addExit(Room r, int i) { // i = Array index
		Directions[i] = r;				// r = room the player will travel too 	//Adds room and direction of said room to the array
	}
	public Room getExit(int i) { //i = Array index
		return Directions[i];
	}
	public void setItem(String word,Item n) {
		item.put(word,n);
	}
	public Item getItem(String n) {
		return item.get(n);
	}
	public void removeItem(String n) {
		item.remove(n);
	}
	public void setifOpen(boolean open) {
		isOpen = open;
	}
	public boolean openOrCLosed(){
		return isOpen;
	}
	public String getName() {
		return Name;
	}
}
