package graph.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    /*------------------------------------------dfs--------------------------------------------------------*/
    public int numIslands(char[][] grid) {
        //定义一个表示岛屿数量的变量
        int count = 0;
        //这个两层for循环是用来遍历整张二维表格中所有的陆地
        //其中 i 表示行，j 表示列
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //取出所有的陆地
                if (grid[i][j] == '1') {
                    //深度递归，遍历所有的陆地
                    dfs(grid, i, j);
                    //用来统计有多少岛屿，岛屿是由多个陆地组成的，概念不一样
                    count++;
                }
            }
        }
        //返回岛屿的数量
        return count;
    }
    private void dfs(char[][] grid, int r, int c) {
        //检查是否超出grid范围
        if (!inArea(grid, r, c)) {
            return;
        }
        if (grid[r][c] != '1') {
            return;
        }
        // 标记遍历过的陆地
        grid[r][c] = '2';
        // 深搜上下左右的格子
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    private boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
    /*------------------------------------------bfs--------------------------------------------------------*/
    public int numIslands2(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1')
                    continue;
                queue.offer(new int[]{i, j});
                grid[i][j] = '2';
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int row = cur[0];
                    int col = cur[1];
                    if (row + 1 < m && grid[row + 1][col] == '1'){
                        grid[row + 1][col] = '2';
                        queue.offer(new int[]{row + 1, col});
                    }
                    if (row - 1 >= 0 && grid[row - 1][col] == '1'){
                        grid[row - 1][col] = '2';
                        queue.offer(new int[]{row - 1, col});
                    }
                    if (col + 1 < n && grid[row][col + 1] == '1'){
                        grid[row][col + 1] = '2';
                        queue.offer(new int[]{row, col + 1});
                    }
                    if (col - 1 >= 0 && grid[row][col - 1] == '1'){
                        grid[row][col - 1] = '2';
                        queue.offer(new int[]{row, col - 1});
                    }
                }
                result++;
            }
        }
        return result;
    }
}
