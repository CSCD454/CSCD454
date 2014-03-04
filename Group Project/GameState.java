package GroupProject;

import java.util.ArrayList;

public interface GameState {
	public ArrayList<CharFactory.Character> Initialize();
	public void Move();
	public ArrayList<CharFactory.Character> BuildMonster();
	public void Encounter(ArrayList<CharFactory.Character> hero);
	public void GameOver();
}
