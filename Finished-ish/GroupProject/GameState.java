package GroupProject;

import java.util.ArrayList;
import CharFactory.Character;

public interface GameState {
	public ArrayList<Object> Initialize();
	public void Move(Character character);
	public ArrayList<Character> BuildMonster();
	public void Encounter(ArrayList<Character> hero);
	public void GameOver();
}
