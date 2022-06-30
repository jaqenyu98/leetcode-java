package dfs;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Map<Character, String> dict = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return result;
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        dfs(digits, 0);
        return result;
    }
    private void dfs(String digits, int idx) {
        if (sb.length() == digits.length()) {
            result.add(new String(sb));
            return;
        }
        String str = dict.get(digits.charAt(idx));
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
