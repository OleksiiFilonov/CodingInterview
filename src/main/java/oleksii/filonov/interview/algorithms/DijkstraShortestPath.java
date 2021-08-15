package oleksii.filonov.interview.algorithms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DijkstraShortestPath {

    private static class Distance {
        private final int vertex;
        private final int distanceSoFar;

        public Distance(int vertex, int distanceSoFar) {
            this.vertex = vertex;
            this.distanceSoFar = distanceSoFar;
        }
    }

    public int[][] findWithMinHeap(int[][] edges, int source) {
        Set<Integer> visited = new HashSet<>();
        Queue<Distance> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.distanceSoFar));
        final int length = edges.length;
        final int[][] result = initializeResult(source, length);

        iterate(visited, minHeap, result, edges, source);
        while (!minHeap.isEmpty()) {
            Distance distance = minHeap.poll();
            iterate(visited, minHeap, result, edges, distance.vertex);
        }
        return result;
    }

    public int[][] findWithAdjacencyMatrix(int[][] edges, int source) {
        final int[][] result = initializeResult(source, edges.length);
        for(int i = 0; i < edges.length; i++) {
            if (edges[source][i] >= 0) {
                result[0][i] = edges[source][i];
                result[1][i] = source;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges[i].length; j++) {
                if(edges[i][j] > 0 && result[0][j] > result[0][i] + edges[i][j]) {
                    result[0][j] = result[0][i] + edges[i][j];
                    result[1][j] = i;
                }
            }
        }
        return result;
    }

    private void iterate(Set<Integer> visited, Queue<Distance> minHeap, int[][] result, int[][] edges, int vertex) {
        visited.add(vertex);
        for (int i = 0; i < edges[vertex].length; i++) {
            final int to = edges[vertex][i];
            if (!visited.contains(i)
                    && to > 0
                    && result[0][i] > result[0][vertex] + to) {
                minHeap.add(new Distance(i, result[0][vertex] + to));
                result[0][i] = result[0][vertex] + to;
                result[1][i] = vertex;
            }
        }
    }

    private int[][] initializeResult(int source, int length) {
        final int[][] result = new int[2][length];
        for (int i = 0; i < length; i++) {
            result[0][i] = Integer.MAX_VALUE;
            result[1][i] = -1;
        }
        result[0][source] = 0;
        result[1][source] = source;
        return result;
    }
}
