package graph.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    /*-------------------------------------------------------------490题------------------------------------------------------------------------*/
    /*------------------------------------------dfs--------------------------------------------------------*/
    boolean[][] visited;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        return hasPath(maze, start[0], start[1], destination);
    }

    private boolean hasPath(int[][] maze, int row, int col, int[] destination) {
        if (visited[row][col])
            return false;
        if (row == destination[0] && col == destination[1])
            return true;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            while (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] == 0) {
                r += dir[0];
                c += dir[1];
            }
            r -= dir[0];
            c -= dir[1];
            if(hasPath(maze, r, c, destination))
                return true;
        }
        return false;
    }

    /*------------------------------------------bfs--------------------------------------------------------*/
    public boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        // 四个方向。
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            if (row == destination[0] && col == destination[1])
                return true;
            // 将四个方向直接统一起来。秀儿
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                while (r >= 0 && c >= 0 && r < m && c < n && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if (!visited[r][c]) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return false;
    }
    /*-------------------------------------------------------------505题------------------------------------------------------------------------*/
    /*------------------------------------------bfs--------------------------------------------------------*/
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] arr : distance)
            Arrays.fill(arr, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                int steps = 0;
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                    steps++;
                }
                r -= dir[0];
                c -= dir[1];
                if (distance[row][col] + steps < distance[r][c]) {
                    distance[r][c] = distance[row][col] + steps;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
    /*------------------------------------------dfs--------------------------------------------------------*/
    int[][] distance;
    // int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance2(int[][] maze, int[] start, int[] destination) {
        distance = new int[maze.length][maze[0].length];
        for (int[] arr : distance)
            Arrays.fill(arr, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start[0], start[1]);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
    private void dfs(int[][] maze, int row, int col) {
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            int steps = 0;
            while (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] == 0) {
                r += dir[0];
                c += dir[1];
                steps++;
            }
            r -= dir[0];
            c -= dir[1];
            if (distance[row][col] + steps < distance[r][c]) {
                distance[r][c] = distance[row][col] + steps;
                dfs(maze, r, c);
            }
        }
    }
}
