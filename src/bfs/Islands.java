package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Islands {
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
    public int numIslandsBfs(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    // 用一个数存两个信息：r和c
                    queue.offer(i * cols + j);
                    while (!queue.isEmpty()) {
                        int temp = queue.poll();
                        int r = temp / cols;
                        int c = temp % cols;
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            grid[r - 1][c] = '2';
                            queue.offer((r - 1) * cols + c);
                        }
                        if (r + 1 < rows && grid[r + 1][c] == '1') {
                            grid[r + 1][c] = '2';
                            queue.offer((r + 1) * cols + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            grid[r][c - 1] = '2';
                            queue.offer(r * cols + c - 1);
                        }
                        if (c + 1 < cols && grid[r][c + 1] == '1') {
                            grid[r][c + 1] = '2';
                            queue.offer(r * cols + c + 1);
                        }
                    }
                    count++;
                }
            }
        }
        //返回岛屿的数量
        return count;
    }

}
