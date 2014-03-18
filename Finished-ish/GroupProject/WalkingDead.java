package GroupProject;

import java.util.ArrayList;

public class WalkingDead {

	public static void main(String[] args) {

		ArrayList<CharFactory.Character> battleList, heroList;

		Game walkingDead = new Game();

		heroList = walkingDead.Initialize();
		CharFactory.Character character = heroList.get(0);
		walkingDead.Move(character);
		while (walkingDead.state != walkingDead.overgame)
		{
			battleList = walkingDead.BuildMonster();
			if (battleList == null)
			{
				walkingDead.GameOver();
			}
			else
			{
				if (battleList.size() == 2)
				{ }
				else
				{
					for(int i = 0; i < heroList.size(); i++) {
						battleList.add(heroList.get(i));
					}
				}
				walkingDead.Encounter(battleList);
			}
		}
	}//end main

}
