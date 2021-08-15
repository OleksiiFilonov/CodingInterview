package oleksii.filonov.interview.tasks.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Find critical connections in the network (edges if removed will brake the network connectivity
 */
public class CriticalConnections {
    private static int[] discover;
    private static int[] earliest;
    private static boolean[] visited;
    private static List<Integer>[] graph;
    private static int time;

    public static List<List<Integer>> find_critical_connections(int number_of_servers, List<List<Integer>> connections) {
        discover = new int[number_of_servers];
        earliest = new int[number_of_servers];
        visited = new boolean[number_of_servers];
        graph = (List<Integer> []) new List [number_of_servers];
        for (int i = 0; i < number_of_servers; i++)
            graph[i] = new ArrayList<>();
        for (List<Integer> edge: connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, bridges);
        if (bridges.isEmpty())
            bridges.add(List.of(-1, -1));
        return bridges;
    }

    private static void dfs(int toVisit, int parent, List<List<Integer>> bridges) {
        visited[toVisit] = true;
        discover[toVisit] = earliest[toVisit] = time++;
        for (int neighbor: graph[toVisit]) {
            if (neighbor == parent)
                continue;
            if (visited[neighbor]) {
                earliest[toVisit] = Math.min(earliest[toVisit], earliest[neighbor]);
            } else {
                dfs(neighbor, toVisit, bridges);
                if (discover[toVisit] < earliest[neighbor])
                    bridges.add(List.of(toVisit, neighbor));
                earliest[toVisit] = Math.min(earliest[toVisit], earliest[neighbor]);
            }
        }
    }
}
