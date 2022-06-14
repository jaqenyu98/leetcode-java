package multiPointers.string;

public class LongestPalindromicSubstring {
    /*-------------------------------------------------------中心扩散法----------------------------------------------------------*/
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] odd = expandAroundCenter(s, i, i);
            int[] even = expandAroundCenter(s, i, i + 1);
            int[] max = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            if (max[1] - max[0] > end - start) {
                start = max[0];
                end = max[1];
            }
        }
        return s.substring(start, end + 1);
    }
    // 数组第一位记录起始位置，第二位终止位置
    private int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
    /*-------------------------------------------------------动态规划----------------------------------------------------------*/
    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        // maxLen初始化是1，一个字母也是回文！
        int maxLen = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (j - i > 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                } else if (j - i == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
