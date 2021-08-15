package oleksii.filonov.interview.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfIslandsCounterTest {
	
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
	 *	0 x 0 0 x x 0 x 0 0 0 x 0
	 *	0 0 x x x 0 0 0 x 0 x x 0 --> 6 islands
	 *	x 0 0 x x 0 0 x x 0 0 x x
	 */
	
	@Test
	public void countNumberOfIslands() {
		char[][] threeIslands = { { '0', 'x', '0' }, { '0', '0', 'x' }, { '0', 'x', '0' } };
		assertEquals(3, NumberOfIslandsCounter.countNumberOfIslands(threeIslands));
		char[][] twoIslands = { { '0', 'x', 'x' }, { '0', '0', 'x' }, { '0', 'x', '0' } };
		assertEquals(2, NumberOfIslandsCounter.countNumberOfIslands(twoIslands));
		char[][] eightIslands = { { '0', 'x', '0', 'x', 'x', 'x', '0', 'x', '0', '0', 'x', 'x', '0' },
								  { '0', '0', '0', '0', '0', 'x', '0', '0', 'x', '0', 'x', '0', '0' },
								  { 'x', '0', '0', 'x', 'x', '0', '0', 'x', 'x', '0', '0', 'x', 'x' } };
		assertEquals(8, NumberOfIslandsCounter.countNumberOfIslands(eightIslands));
		char[][] sixIslands = { { '0', 'x', '0', '0', 'x', 'x', '0', 'x', '0', '0', '0', 'x', '0' },
								{ '0', '0', 'x', 'x', 'x', '0', '0', '0', 'x', '0', 'x', 'x', '0' },
								{ 'x', '0', '0', 'x', 'x', '0', '0', 'x', 'x', '0', '0', 'x', 'x' } };
		assertEquals(6, NumberOfIslandsCounter.countNumberOfIslands(sixIslands));
	}

}
