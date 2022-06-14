package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    /*----------------------------------------------dfs-------------------------------------------*/
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms, int node) {
        if (visited[node])
            return;
        visited[node] = true;
        for (int neighbor : rooms.get(node)) {
            if (!visited[neighbor])
                dfs(rooms, neighbor);
        }
    }
    /*----------------------------------------------bfs-------------------------------------------*/
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : rooms.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}
