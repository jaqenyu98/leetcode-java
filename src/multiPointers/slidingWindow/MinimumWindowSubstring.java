package multiPointers.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int needCnt = need.size();
        int left = 0;
        int right = 0;
        int resultStart = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (window.get(rightChar).equals(need.get(rightChar)))
                    needCnt--;
            }
            while (needCnt == 0) {
                if (right - left < minLen) {
                    resultStart = left;
                    minLen = right - left;
                }
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(need.get(leftChar)))
                        needCnt++;
                    window.put(leftChar, window.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resultStart, resultStart + minLen);
    }
}
