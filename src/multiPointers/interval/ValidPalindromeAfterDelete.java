package multiPointers.interval;

public class ValidPalindromeAfterDelete {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r - 1);
            }
        }
        return true;
    }
    private boolean validPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
