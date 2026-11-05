package game;

public class World {

	public static Room buildWorld() {
		Room livingRoom = new Room("Living Room", "This is a small living room with a couch and coffee table.");
		Room bedRoom = new Room("Bedroom",
				"This is the master bedroom which has a king sized bed with a nightstand beside it");
		Room attic = new Room("Attic",
				"A nice and spacious Attic. Theres some doll houses in the far right corner "
						+ "with boxes littered around the room");
		Room office = new Room("Office", "A simple and small work office with a desk and chair in the middle");
		Room kitchen = new Room("Kitchen",
				"A clean Kitchen with all you would expect including a small island in the middle.");
		Room garage = new Room("garage",
				"Heres the garage. There is a a white toyoda in the center along with a work bench hugging the wall in an L shape in the corner");
		//Bedroom
		bedRoom.addExit(attic, 4);
		bedRoom.addExit(livingRoom, 3);
		//Living Room
		livingRoom.addExit(bedRoom, 2);
		livingRoom.addExit(office, 1);
		livingRoom.addExit(kitchen, 0);
		//Office 
		office.addExit(livingRoom, 0);
		//Kitchen
		kitchen.addExit(livingRoom, 1);
		kitchen.addExit(garage, 3);

		//Attic
		attic.addExit(bedRoom, 5);
		//garage
		garage.addExit(kitchen, 2);
		//Items
		Officekey officekey = new Officekey();
		bedRoom.setItem("officekey",officekey);
		Tool tool = new Tool();
		livingRoom.setItem("tool",tool);
		Item musicbox = new Item("music Box");
		livingRoom.setItem("music Box",musicbox);
		
		Item couch = new Item("couch");
		livingRoom.setItem("couch",couch);
		couch.setweight(true);
		
		Item flashlight = new Item("flashlight");
		kitchen.setItem("flashlight",flashlight);
		
		Item knife = new Item("knife");
		kitchen.setItem("knife",knife);
		
		Item safe = new safe();
		attic.setItem("safe",safe);
		safe.setweight(true);
		
		Item mysteriousorb = new Item("mysteriousorb");
		kitchen.setItem("mysterious orb" , mysteriousorb);
		//Open or closed
		office.setifOpen(false);
		attic.setifOpen(false);
		garage.setifOpen(false);
		
		return livingRoom;
		
	}

	public static void main(String[] args) {
		Room currentRoom = buildWorld();
		System.out.println(currentRoom); // living room
		currentRoom = currentRoom.getExit(0); // 0=east
		System.out.println(currentRoom); // kitchen
		currentRoom = currentRoom.getExit(3); // 3=south
		System.out.println(currentRoom); // garage
		currentRoom = currentRoom.getExit(2); // 2=north
		System.out.println(currentRoom); // kitchen again
		currentRoom = currentRoom.getExit(1); // 1=west
		System.out.println(currentRoom); // living room again
		currentRoom = currentRoom.getExit(2); // 2=north
		System.out.println(currentRoom); // bedroom
		currentRoom = currentRoom.getExit(4); // 4=up
		System.out.println(currentRoom); // attic		

	}
}
