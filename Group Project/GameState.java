package GroupProject;

import java.util.ArrayList;

public interface GameState {
	public ArrayList<Character> Initialize();
	public void Move();
	public ArrayList<Character> BuildMonster();
	public void Encounter(ArrayList<Character> hero);
	public void GameOver();
}
