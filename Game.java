package game;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Game {
	private static Consumer<String> output = System.out::println;
	private static Room Location = World.buildWorld(); //Players Location
	public static HashMap<String, String> rooms = new HashMap<>();
	protected static ArrayList<Item> Storage = new ArrayList<>();
	public static void takeItem(String name) {
		if(Location.getItem(name).getItem() == null) {
			Game.print("There is nothing to take fatty");
		
		}else if(!(name.equals(Location.getItem(name).getItem()))){
		Game.print("There is no " + name + " here big boi" );	
		}else if(Location.getItem(name).isheavy() == true) {
			Game.print("You can't lift the " + name + "!");
			
		}else {
			Storage.add(Location.getItem(name));
			Game.print("You take the " + Location.getItem(name) + " and carry it with you!");
			Location.removeItem(name);
		}
	}
	public static void destoMap() {
		try {
			Scanner fileScan = new Scanner(new File("room_descriptions.txt"));
			while(fileScan.hasNextLine()) {
				String Des = "";
				String name = fileScan.nextLine();
				String des = fileScan.nextLine();
				while(!des.equals("#")) {
					Des += des;
					des = fileScan.nextLine();
				}
				rooms.put(name,Des);
			}
			fileScan.close();
		}catch(Exception ex) {
			ex.printStackTrace(); // if it catches it it simply prints it if it cant do the "try"
		}	
	}
	public static void print(Object obj) {
	    output.accept(String.valueOf(obj));
	}
	 //////////////////////
		public static void move(String way) {
		int i = 0;
		switch(way.toUpperCase()) {
		
		case "EAST": 
			i = 0;
			if(Location.getExit(i) == null) {
				Game.print("ERROR: Cant travel in this direction");
			}else if(Location.getExit(i).openOrCLosed() == false) {
				Game.print("This door is locked as fucked, like ts so locked its crazy");
			}else{
					Location = Location.getExit(i);		
			}
			break;
			case "WEST":
				i = 1;
				if(Location.getExit(i) == null) {
					Game.print("ERROR: Cant travel in this direction");
				}else if(Location.getExit(i).openOrCLosed() == false) {
					Game.print("This door is locked as fucked, like ts so locked its crazy");
				}
				else{
						Location = Location.getExit(i);
				}
				break;
			case "NORTH":
				i = 2;
				if(Location.getExit(i) == null) {
					Game.print("ERROR: Cant travel in this direction");
				}else if(Location.getExit(i).openOrCLosed() == false) {
					Game.print("This door is locked as fucked, like ts so locked its crazy");
				}
				
				else{
						Location = Location.getExit(i);		
				}
				break;
			case "SOUTH":
				i = 3;
				if(Location.getExit(i) == null) {
					Game.print("ERROR: Cant travel in this direction");
				}else if(Location.getExit(i).openOrCLosed() == false) {
					Game.print("This door is locked as fucked, like ts so locked its crazy");
				}else{
						Location = Location.getExit(i);		
				}
				break;
			case "UP":
				i = 4;
				if(Location.getExit(i) == null) {
					Game.print("ERROR: Cant travel in this direction");
				}else if(Location.getExit(i).openOrCLosed() == false) {
					Game.print("This door is locked as fucked, like ts so locked its crazy");
				}else{
						Location = Location.getExit(i);		
				}
				break;
			case "DOWN":
				i = 5;
				if(Location.getExit(i) == null) {
					Game.print("ERROR: Cant travel in this direction");
				}else if(Location.getExit(i).openOrCLosed() == false) {
					Game.print("This door is locked as fucked, like ts so locked its crazy");
				}else{
						Location = Location.getExit(i);		
				}
				break;
			default:
				Game.print("ERROR: You had six choices, " + way + " was not one of them.");
				// 0 = east\n
			 	//1 = west\n
				//2 = north\n
					//3= south\n
					//4=up\n
				//5=down
		}
		}
	public static void main(String[] args) {
		destoMap();
		runGame();
	}
	public static void runGame() {
		Scanner input = new Scanner(System.in);
				String word = ""; 
		do{
			
			
			Game.print(Location);
			Game.print("Enter command");
			String wordd = input.nextLine(); // Takes the word
			
			wordd = wordd.replaceAll("the", ""); //Replaces all parameters with nothing
			wordd = wordd.replaceAll("to", ""); 
			wordd = wordd.replaceAll("\\s+", " ");
			String[] b  = wordd.split(" ");	//Splits word into two if space is included
			//String[] b  = wordd.split(" ");
			word = b[0];
			switch(word.toUpperCase()) {
			
			case "EAST": 
				move(word);
				break;
				case "WEST":
					
					move(word);
					break;
				case "NORTH":
					move(word);
					break;
				case "SOUTH":
					move(word);
					break;
				case "UP":
					move(word);
					break;
				case "DOWN":
					move(word);
					break;
						
						
				case "I":
					if (Storage.size() == 0) {
						Game.print("You are carring nothing");
					}else {
						Game.print("Invertory");
						Game.print("");
						for (Item i : Storage) {
							 String p = i.toString();
							 Game.print(p);
						}
						Game.print("");
					}
					
					break;
				case "TAKE":
					if(b.length == 2)
					takeItem(b[1].toLowerCase());
					else 
						Game.print("Take what?");
					break;
				case "GO":
					move(b[1]);
					break;
				case "SAVE":
					savegame();
					break;
				case "LOAD":
					
						readdatfile();
					
					break;
					
				default:
					Game.print("ERROR: You had six choices, " + word + " was not one of them.");
			}
		}while(!word.toLowerCase().equals("exit"));
		
		
	}
	public static void setOutput(
	        java.util.function.Consumer<String> destination) {
	    output = destination;
	}

	public static void startGame() {
	    print(Location);
	    print("");
	    print("Enter command");
	}

	public static boolean executeCommand(String command) {
	    String cleaned = command.trim().replaceAll("\\s+", " ");
	    
	    if (cleaned.isEmpty()) {
	        return true;
	    }

	    String[] parts = cleaned.split(" ", 2);
	    String word = parts[0].toUpperCase();

	    switch (word) {
	        case "EAST":
	        case "WEST":
	        case "NORTH":
	        case "SOUTH":
	        case "UP":
	        case "DOWN":
	            move(word);
	            break;

	        case "GO":
	            if (parts.length < 2) {
	                print("Go where?");
	            } else {
	                move(parts[1].trim().toUpperCase());
	            }
	            break;

	        case "I":
	            if (Storage.isEmpty()) {
	                print("You are carrying nothing.");
	            } else {
	                print("Inventory");
	                for (Item item : Storage) {
	                    print(item);
	                }
	            }
	            break;

	        case "TAKE":
	            if (parts.length < 2) {
	                print("Take what?");
	            } else {
	                takeItem(parts[1].trim().toLowerCase());
	            }
	            break;
	            
	        case "LOOK":
	            print(Location);
	            break;
	        //
	        
	        //
	        case "HELP":
	            print("Commands: north, south, east, west, up, down,");
	            print("go <direction>, take <item>, i, look, exit");
	            break;
	            ///
	        case "SAVE":
				savegame();
				break;
			case "LOAD":		
					readdatfile();
				break;
			case "USE":
				boolean haveItem = false;
				Item current_Item = null;
				if(parts.length == 2) {
						for(Item item: Storage) {
							if (item.getItem().equals(parts[1])) {
								haveItem = true;
								current_Item = item;
							}
						}
						if(haveItem) {
							current_Item.use();
						}
					
				}else
					//current_Item.use();
					Game.print("Use what?");
				break;
			case "OPEN":
				Item current_item = null;
				if(parts.length == 2) {
				 current_item = Location.getItem(parts[1]);
				current_item.open();
				}else {
					Game.print("Open what");
				}
				break;
			case "CLOSE":
				 current_item = null;
				if(parts.length == 2) {
					 current_item = Location.getItem(parts[1]);
					current_item.close();
					}else {
						Game.print("Close what");
					}
					break;
			case "READ":
				 haveItem = false;
				 current_Item = null;
				if(parts.length == 2) {
						for(Item item: Storage) {
							if (item.getItem().equals(parts[1])) {
								haveItem = true;
								current_Item = item;
							}
						}
						if(haveItem) {
							current_Item.read();
						}
					
				}else
					//current_Item.use();
					Game.print("read what?");
				break;
	            ///
	        case "EXIT":
	        case "QUIT":
	            print("You leave the adventure behind.");
	            return false;

	        default:
	            print("Unknown command: " + cleaned);
	    }

	    print("");
	    print(Location);
	    print("");
	    print("Enter command");
	    return true;
	}
	public static void savegame() {
		File saveFile = new File("sooSaved.sav"); // name the file yourself
		try {
			
			saveFile.createNewFile(); // c
			ObjectOutputStream outStream = new ObjectOutputStream(new
		FileOutputStream(saveFile));
		outStream.writeObject(Location);
		outStream.writeObject(Storage);
		outStream.close();
		}catch(Exception ex) {
			ex.printStackTrace(); // if it catches it it simply prints it if it cant do the "try"
		}	
	}
	public static void readdatfile() {
		File saveFile = new File("sooSaved.sav"); // name of save file
		try {
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(saveFile));
			Location = (Room) inStream.readObject();
			Storage = (ArrayList<Item>) inStream.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static Room getCurrentRoom() {
		return Location;
	}
	public void addInventoryItem(Item i) {
		Storage.add(i);
	}

}