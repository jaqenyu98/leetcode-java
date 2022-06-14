package graph.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    /*---------------------------------------------bfs--------------------------------------------------*/
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    count++;
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }
        int minute = 0;
        while (!queue.isEmpty() && count > 0) {
            int size = queue.size();
            minute++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        queue.offer(new int[]{r, c});
                        grid[r][c] = 2;
                        count--;
                    }
                }
            }
        }
        return count == 0 ? minute : -1;
    }
}
