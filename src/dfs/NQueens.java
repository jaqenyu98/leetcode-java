package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        dfs(n, 0, chessboard);
        return result;
    }
    private void dfs(int n, int row, char[][] chessboard) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] chars : chessboard) {
                temp.add(new String(chars));
            }
            result.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(n, chessboard, row, col)) {
                chessboard[row][col] = 'Q';
                dfs(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }
    private boolean isValid(int n, char[][] chessboard, int row, int col) {
        // 检测列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q')
                return false;
        }
        // 检测对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        // 检测对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n ; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
