package multiPointers.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            while (r < n && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            max = Math.max(max, r - l);
            set.remove(s.charAt(l));
            l++;
        }
        return max;
    }
}
