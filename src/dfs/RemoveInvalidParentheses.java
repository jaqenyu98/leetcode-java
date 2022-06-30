package dfs;

import java.util.*;

public class RemoveInvalidParentheses {
    /*----------------------------------------------dfs-------------------------------------------*/
    List<String> result = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0;
        int rRemove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lRemove++;
            } else if (c == ')') {
                if (lRemove > 0) {
                    lRemove--;
                } else {
                    rRemove++;
                }
            }
        }
        dfs(s, lRemove, rRemove, 0);
        return result;
    }
    private void dfs(String s, int lRemove, int rRemove, int startIndex) {
        if (lRemove == 0 && rRemove == 0 && isValid(s)) {
            result.add(s);
            return;
        }
        // 从start开始去，避免重复。
        for (int i = startIndex; i < s.length(); i++) {
            // 剪枝，如果剩余字符个数小于要去掉的字符数，直接返回
            if (lRemove + rRemove > s.length() - i)
                break;
            // 连续相等的跳过，避免重复
            if (i != startIndex && s.charAt(i) == s.charAt(i - 1))
                continue;
            // 去左或去右二选一
            if (lRemove > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), lRemove - 1, rRemove, i);
            } else if (rRemove > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), lRemove, rRemove - 1, i);
            }
        }
    }
    private boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
                if (cnt < 0)
                    return false;
            }
        }
        return cnt == 0;
    }
    /*----------------------------------------------bfs-------------------------------------------*/
    public List<String> removeInvalidParentheses2(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (isValid2(str)) {
                result.add(str);
                found = true;
            }
            // 如果找到符合要求的，就找到最短去掉的个数了，也就不用再进行下面的for循环了，直接把队列里现有的所有字符串判断一遍即可。
            if (found)
                continue;
            // 对当前字符串的每一个字符尝试去掉，将结果入队。
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')')
                    continue;
                String newStr = str.substring(0, i) + str.substring(i + 1);
                // set去重，没出现过的才入队
                if (!visited.contains(newStr)) {
                    visited.add(newStr);
                    queue.offer(newStr);
                }
            }
        }
        return result;
    }
    private boolean isValid2(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
                if (cnt < 0)
                    return false;
            }
        }
        return cnt == 0;
    }
}
