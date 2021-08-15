package oleksii.filonov.interview.tasks;

/** 
 *	Count the number of islands: 0 - water, x - island
 *	0 x 0					0 x x
 *	0 0 x	--> 3 islands	0 0 x	--> 2 islands
 *	0 x 0 					0 x 0
 *
 *	0 x 0 x x x 0 x 0 0 x x 0
 *	0 0 0 0 0 x 0 0 x 0 x 0 0 --> 8 islands
 *	x 0 0 x x 0 0 x x 0 0 x x
 *
 */
public class NumberOfIslandsCounter {

	public static int countNumberOfIslands(char[][] coordinates) {
		int length = coordinates.length;
		int counter = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < coordinates[i].length; j++) {
				if (coordinates[i][j] == 'x') {
					visitIsland(coordinates, i, j);
					counter++;
				}
			}
		}
		return counter;
	}

	private static void visitIsland(char[][] coordinates, int i, int j) {
		if (i >= 0 && i < coordinates.length 
				&& j >= 0 && j < coordinates[i].length 
				&& coordinates[i][j] == 'x') {
			coordinates[i][j] = 'v';
			visitIsland(coordinates, i, j - 1);
			visitIsland(coordinates, i + 1, j);
			visitIsland(coordinates, i - 1, j);
			visitIsland(coordinates, i, j + 1);
		}
	}

}
