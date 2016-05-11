import java.util.ArrayList;

/**
 * Inventory class to hold which items are in which room
 * @author sarahtrop
 *
 */
public class Inventory {
	
	ArrayList<Item> inventory;
	
	/**
	 * Constructor
	 */
	public Inventory() { inventory = new ArrayList<>(); }
	
	/**
	 * Method checks if an item (described by its title) is in the inventory already
	 * @param item	an Item
	 * @return		a boolean
	 */
	public boolean contains(String item) {
		for (Item i : inventory) {
			if (i.title.equals(item)) { return true; }
		}
		return false;
	}
	
	/**
	 * Method to update the inventory
	 * @param room	a Room
	 */
	public void update(Room room) { inventory = room.getItems(); }
	/**
	 * Method to add an item to the inventory
	 * @param item	an Item
	 */
	public void add(Item item) { inventory.add(item); }
	
	/**
	 * Method to "pick up" an item in the adventure game
	 */
	public void pickUp(Item item) {
		if (inventory.contains(item)) {
			System.out.println("You've picked up " + item.title);
			System.out.println(item.effect);
			if (item.title.equals("Eliot's jacket")) {
				System.out.println("There seems to be something in the pocket! Maybe if you use the jacket you can find out what it is.");
			}
		} else { System.out.println("You can't do that. Try something else."); }
	}
	
	/**
	 * Method to "talk to" an item or person in the adventure game
	 */
	public void talkTo(Item item) {
		if (inventory.contains(item)) {
			if (item instanceof Person) { System.out.println(item.title + " says, " + "'" + item.effect + "'"); }
			else { System.out.println("You've found " + item.title); }
		}
		else { System.out.println("That item is not in this room. Try something else."); }
	}
	
	/** 
	 * Method to "learn more" about an item or person in the adventure game
	 */
	public void more(Item item) {
		if (inventory.contains(item)) {
			if (item instanceof Person) { System.out.println(item.title + " says, " + item.more); }
			else { System.out.println(item.more); }
			System.out.println();
			System.out.println("You've gained " + item.points + " points(s)!");
		} else { System.out.println("You can't do that. Try something else."); }
	}
	
	
	/**
	 * Method to "look at" an item in the adventure game
	 */
	public void lookAt(Item item) {
		if (inventory.contains(item)) {
			System.out.println(item.desc);
			if (item.more.equals("null")) { System.out.println("You've gained " + item.points + " point(s)!"); }
		} else { System.out.println("You can't do that. Try something else."); }
	}
}