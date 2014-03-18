package RoomBuilder;

public class MapMaker {

	private int size;
	private int[][] map;
	private int[] winLocation = new int[2];

	public MapMaker() {

	}

	public int[][] makeMap(int mapSize) {
		this.size = mapSize;
		map = new int[size][size];

		for(int i = 0; i < size; i++) {
			for(int x = 0; x < size; x++) {
				map[i][x] = 0;
			}
		}

		getStartLocation();
		getWinLocation();

		return map;
	}//end makeMap

	public int getSize() {		
		return size;
	}//end getSize

	private void getStartLocation() {
		map[getRandNum() - 1][getRandNum() - 1] = 1;
	}//end getStartLocation

	private void getWinLocation() {
		winLocation[0] = (getRandNum() - 1);
		winLocation[1] = (getRandNum() - 1);
		map[winLocation[0]][winLocation[1]] = 4;
	}//end getWinLocation

	private int getRandNum() {
		return (int) (Math.random() * size + 1);
	}//end getRandNum

	public void setMapLocation(int[] loc) {
		int[] locNew = loc;
		int[] locOld = findLocation();
		
		map[locOld[0]][locOld[1]] = 2;
		map[locNew[0]][locNew[1]] = 1;
	}//end setMapLocation

	public int[] findLocation() {
		int[] loc = new int[2];

		for(int x = 0; x < size; x++) {
			for(int y = 0; y < size; y++) {
				if(map[x][y] == 1) {
					loc[0] = x;
					loc[1] = y;
				}
			}
		}

		return loc;
	}//end findLocation

	public void printMap() {
		for(int i = 0; i < size; i++) {
			for(int x = 0; x < size; x++) {
				System.out.print(map[i][x] + " ");
			}
			System.out.println();
		}
		System.out.println("\nLegend\n0 - Un-visited\n1 - Current location\n2 - Visited\n4 - End");
	}//end printMap

	public boolean checkWin(int[] loc) {
		int win = map[winLocation[0]][winLocation[1]];
		int locAt = map[loc[0]][loc[1]];
		
		if(locAt == win) {
			return true;
		}
		else
			return false;
	}//end checkWin

}
