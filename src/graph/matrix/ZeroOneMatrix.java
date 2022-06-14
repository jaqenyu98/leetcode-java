package graph.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    /*-------------------------------------------------bfs层序遍历---------------------------------------------*/
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        // 将结果初始化为-1，表示未访问过
        for (int[] row : result)
            Arrays.fill(row, -1);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    result[i][j] = 0;
                }

            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int cur[] = queue.poll();
                int row = cur[0];
                int col = cur[1];
                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    // 如果未访问过，入队，并更新距离原点的distance
                    if (r >= 0 && r < m && c >= 0 && c < n && result[r][c] == -1) {
                        queue.offer(new int[]{r, c});
                        result[r][c] = step;
                    }
                }
            }
        }
        return result;
    }

    /*-------------------------------------------------bfs小动规---------------------------------------------*/
    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        // 将结果初始化为-1，表示未访问过
        for (int[] row : result)
            Arrays.fill(row, -1);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    result[i][j] = 0;
                }

            }
        }
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int row = cur[0];
            int col = cur[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && result[r][c] == -1) {
                    queue.offer(new int[]{r, c});
                    result[r][c] = result[row][col] + 1;
                }
            }
        }
        return result;
    }

    /*-------------------------------------------------动规---------------------------------------------*/
    public int[][] updateMatrix3(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            // 这里太坑了，如果设置为Integer.MAX_VALUE，加1后会溢出！！！
            Arrays.fill(row, Integer.MAX_VALUE - 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    dp[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 相当于dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]); 要处理边界所以分两次写
                if (i - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                if (j - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 相当于dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]); 要处理边界所以分两次写
                if (i + 1 < m)
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j]);
                if (j + 1 < n)
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j + 1]);
            }
        }
        return dp;
    }
}
