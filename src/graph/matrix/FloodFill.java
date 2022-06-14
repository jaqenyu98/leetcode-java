package graph.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    /*------------------------------------------bfs--------------------------------------------------------*/
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && image[r][c] == oldColor) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                    image[r][c] = newColor;
                }
            }
        }
        return image;
    }
    /*------------------------------------------dfs--------------------------------------------------------*/
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        visited[row][col] = true;
        image[row][col] = newColor;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && !visited[r][c] && image[r][c] == oldColor) {
                dfs(image, r, c, oldColor, newColor);
            }
        }
    }
}
