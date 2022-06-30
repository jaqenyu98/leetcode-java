package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0);
        return result;
    }
    private void dfs(int n, int lCnt, int rCnt) {
        if (sb.length() == n * 2) {
            result.add(new String(sb));
            return;
        }
        // 树的同一层，要么左括号要么有括号
        // 依次判断，什么时候能左括号？比较简单，左括号数量小于n即可
        if (lCnt < n) {
            sb.append("(");
            dfs(n, lCnt + 1, rCnt);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 什么时候能右括号？必须右括号数量小于左括号数量才行。
        if (rCnt < lCnt) {
            sb.append(")");
            dfs(n, lCnt, rCnt + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
