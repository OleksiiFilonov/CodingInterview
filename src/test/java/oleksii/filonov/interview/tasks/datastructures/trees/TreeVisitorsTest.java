package oleksii.filonov.interview.tasks.datastructures.trees;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeVisitorsTest {
	
	
	@Test
	public void testCase01() throws Exception {
		File resourceDir = Paths.get("src", "test", "resources").toFile();
		Scanner scan = new Scanner(Paths.get(resourceDir.getPath(), "TreeVisitorsTestCase01.txt").toFile());
		Tree tree = TreeVisitors.solve(scan);
		SumInLeavesVisitor sumInLeavesVisitor = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor productOfRedNodesVisitor = new ProductOfRedNodesVisitor();
		FancyVisitor fancyVisitor = new FancyVisitor();

		tree.accept(sumInLeavesVisitor);
		tree.accept(productOfRedNodesVisitor);
		tree.accept(fancyVisitor);

		assertEquals(45136, sumInLeavesVisitor.getResult());
		assertEquals(56618427, productOfRedNodesVisitor.getResult());
		assertEquals(14333, fancyVisitor.getResult());
	}
	
	@Test
	public void testCaseSample() throws Exception {
		File resourceDir = Paths.get("src", "test", "resources").toFile();
		Scanner scan = new Scanner(Paths.get(resourceDir.getPath(), "TreeVisitorsTestCaseSample.txt").toFile());
		Tree tree = TreeVisitors.solve(scan);
		SumInLeavesVisitor sumInLeavesVisitor = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor productOfRedNodesVisitor = new ProductOfRedNodesVisitor();
		FancyVisitor fancyVisitor = new FancyVisitor();

		tree.accept(sumInLeavesVisitor);
		tree.accept(productOfRedNodesVisitor);
		tree.accept(fancyVisitor);

		assertEquals(27, sumInLeavesVisitor.getResult());
		assertEquals(48, productOfRedNodesVisitor.getResult());
		assertEquals(17, fancyVisitor.getResult());
	}

}
