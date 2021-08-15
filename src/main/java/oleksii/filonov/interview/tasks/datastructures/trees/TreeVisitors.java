package oleksii.filonov.interview.tasks.datastructures.trees;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis {
	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

	private int sum = 0;

	public int getResult() {
		return sum;
	}

	public void visitNode(TreeNode node) {
	}

	public void visitLeaf(TreeLeaf leaf) {
		sum += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {

	private long product = 1;
	private int modulo = 1000000007;
	private List<Integer> redValues = new ArrayList<>();

	public int getResult() {
		return (int) product;
	}

	public void visitNode(TreeNode node) {
		multiply(node);
	}

	public void visitLeaf(TreeLeaf leaf) {
		multiply(leaf);
	}

	private void multiply(Tree tree) {
		if (Color.RED.equals(tree.getColor())) {
			product = (product * tree.getValue()) % modulo;
			redValues.add(tree.getValue());
		}
	}

	public List<Integer> getRedValues() {
		return redValues;
	}
}

class FancyVisitor extends TreeVis {
	// sum of values stored in the tree's non-leaf nodes at even depth
	private int sumNodeEvenDepth = 0;
	// sum of values stored in the tree's green leaf nodes
	private int sumGreenLeaf = 0;

	public int getResult() {
		return Math.abs(sumNodeEvenDepth - sumGreenLeaf);
	}

	public void visitNode(TreeNode node) {
		if (node.getDepth() % 2 == 0) {
			sumNodeEvenDepth += node.getValue();
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (Color.GREEN == leaf.getColor()) {
			sumGreenLeaf += leaf.getValue();
		}
	}
}

public class TreeVisitors {

	private static int n;
	private static int[] values;
	private static byte[] colors;
	private static Map<Integer, HashSet<Integer>> connections = new HashMap<>();
	private static boolean[] visited;

	public static Tree solve(Scanner scanner) {
		n = scanner.nextInt();
		// System.out.println(n);
		values = new int[n];
		colors = new byte[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
		}
		// System.out.println(Arrays.toString(values));
		for (int i = 0; i < n; i++) {
			colors[i] = scanner.nextByte();
			connections.put(i, new HashSet<Integer>());
		}
		// System.out.println(Arrays.toString(colors));
		while (scanner.hasNextInt()) {
			int beginEdge = scanner.nextInt() - 1;
			int endEdge = scanner.nextInt() - 1;
			connections.get(beginEdge).add(endEdge);
			connections.get(endEdge).add(beginEdge);
		}

		return buildDFS();
	}

	public static Tree solve() {
		Scanner scanner = new Scanner(System.in);
		return solve(scanner);
	}

	private static Tree buildDFS() {
		if (connections.get(0).isEmpty()) {
			return new TreeLeaf(values[0], getColor(0), 0);
		} else {
			visited = new boolean[n];
			return runDFS(0, 0);
		}
	}

	private static Tree runDFS(int index, int depth) {
		List<Tree> childs = new ArrayList<>();
		visited[index] = true;
		for (int child : connections.get(index)) {
			if (!visited[child]) {
				childs.add(runDFS(child, depth + 1));
			}
		}
		Color color = getColor(index);
		if (childs.isEmpty()) {
			return new TreeLeaf(values[index], color, depth);
		} else {
			TreeNode node = new TreeNode(values[index], color, depth);
			for (Tree child : childs) {
				node.addChild(child);
			}
			return node;
		}
	}

	private static Color getColor(int index) {
		return Color.values()[colors[index]];
	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}