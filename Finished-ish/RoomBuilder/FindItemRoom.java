package RoomBuilder;

import CharFactory.Character;
import GroupProject.Game;
import ItemFactory.Item;
import ItemFactory.ItemFactory;

public class FindItemRoom extends Room {

	public FindItemRoom(Character character, Game game) {
		this.character = character;
		this.game = game;
		setDescription("item.txt");
	}
	
	public void add() {
		Item item;
		
		item = parseString();
		
		character.setInventory(item);
	}//end add
	
	private Item parseString() {
		ItemFactory factory = new ItemFactory();
		Item item = null;
		String[] tokens = getDescription().split("[ .]+");
		
		for(String t : tokens) {
			if(t.equals("firstaidkit")) {
				item = factory.createItem(t);
				break;
			}
			else if(t.equals("food")) {
				item = factory.createItem(t);
				break;
			}
			else {
				item = factory.createItem("firstaidkit");
			}
		}//end forloop
		
		return item;
	}//end parseString
	
	@Override
	public void roomDone() {
		game.Move(character);
	}//end parseString
}
