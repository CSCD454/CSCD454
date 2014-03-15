package RoomBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import CharFactory.Character;
import GroupProject.Game;


public abstract class Room {

	protected Game game;
	protected Character character;
	private String description;
	private Scanner reader = null;
	private int numOfLines;
	
	
	public Room() {
		
	}
	
	protected void setDescription(String file) {
		Random rg = new Random();
		int index;
		
		countLines(reader, file);
		
		index = rg.nextInt(this.numOfLines);
		
		try {
			this.reader = new Scanner(new File(file));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		for(int i = 0; i < index; i++) {
			reader.nextLine();
		}
		
		this.description = reader.nextLine();
		
		reader.close();
	}//end setDescription
	
	private void countLines(Scanner reader, String file) {
		try {
			reader = new Scanner(new File(file));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		while(reader.hasNext()) {
			reader.nextLine();
			this.numOfLines++;
		}
		reader.close();
	}//end countLines
	
	public String getDescription() {
		return this.description;
	}//end getDescription
	
	public Character getCharBack() {
		return this.character;
	}//end getCharBack
	
	public abstract void add();
	
	public abstract void roomDone();
}
