package dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    /*-------------------------------------------------记忆化回溯--------------------------------------------------------*/
    Set<String> wordSet;
    // visited[i]：表示从i到结尾的字符串能否划分。0代表不知道没遍历过，1代表能划分，2代表不能划分。
    int[] visited;
    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        visited = new int[s.length()];
        return canBreak(s, 0);
    }
    private boolean canBreak(String s, int startIndex) {
        if (startIndex == s.length()) {
            return true;
        }
        if (visited[startIndex] != 0) {
            return visited[startIndex] == 1;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String word = s.substring(startIndex, i + 1);
            if (wordSet.contains(word) && canBreak(s, i + 1)) {
                visited[startIndex] = 1;
                return true;
            }
        }
        visited[startIndex] = 2;
        return false;
    }
    /*------------------------------------------------------动规--------------------------------------------------------*/
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        // dp[i]表示从0到i(exclusive)的字符串能否划分。dp[i] = dp[j] && s[j...i]
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                // 这样写也行，丑了点.
                // dp[i] = dp[j] && wordSet.contains(word);
                // if (dp[i])
                //     break;
                if (dp[j] && wordSet.contains(word)) {
                    dp[i] = true;
                    // 找到一个能拆分的直接break，提高效率
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
