package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    List<String> result = new ArrayList<>();
    Set<String> wordDictSet;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDictSet = new HashSet<>(wordDict);
        dfs(s, 0, "");
        return result;
    }
    private void dfs(String s, int startIndex, String path) {
        if (startIndex == s.length()) {
            result.add(path.substring(1));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String word = s.substring(startIndex, i + 1);
            if (wordDictSet.contains(word)) {
                dfs(s, i + 1, path + " " + word);
            }
        }
    }
}
