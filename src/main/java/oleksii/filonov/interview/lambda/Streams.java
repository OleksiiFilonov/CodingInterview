package oleksii.filonov.interview.lambda;

import java.util.stream.IntStream;

public class Streams {

	public static void main(String[] args) {
		System.out.println("anyMatch return boolean: " + IntStream.range(0, 20).anyMatch(e -> e == 5));
		System.out.println("noneMatch return boolean: " + IntStream.range(0, 20).noneMatch(e -> e == 5));
		System.out.println("reduce Find min element: " + IntStream.of(1, 5, 12, 1, 55, -6).reduce((e1, e2) -> e1 < e2? e1: e2).getAsInt());
	}

}
