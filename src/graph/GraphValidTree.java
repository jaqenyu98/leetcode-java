package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphValidTree {
    /*----------------------------------------------dfs-------------------------------------------*/
    boolean[] visited;
    List<List<Integer>> graph;
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length)
            return false;
        visited = new boolean[n];
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0);
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
    private void dfs(int node) {
        if (visited[node])
            return;
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            dfs(neighbor);
        }
    }
    /*----------------------------------------------bfs-------------------------------------------*/
    public boolean validTree2(int n, int[][] edges) {
        if (n - 1 != edges.length)
            return false;
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}
