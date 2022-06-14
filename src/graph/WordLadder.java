package graph;

import java.util.*;

public class WordLadder {
    /*----------------------------------------------bfs-------------------------------------------*/
    Set<String> wordSet;
    Queue<String> queue;
    Set<String> visited;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord))
            return 0;
        queue = new LinkedList<>();
        queue.offer(beginWord);
        visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                if (canTransform2Endword(curWord, endWord)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }
    private boolean canTransform2Endword(String curWord, String endWord) {
        char[] chars = curWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char originChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originChar)
                    continue;
                chars[i] = c;
                String nextWord = new String(chars);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord))
                        return true;
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            chars[i] = originChar;
        }
        return false;
    }
    /*----------------------------------------------双向bfs-------------------------------------------*/
    // Set<String> wordSet;
    // Set<String> visited;
    Set<String> beginVisited;
    Set<String> endVisited;
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord))
            return 0;
        visited = new HashSet<>();
        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
        beginVisited = new HashSet<>();
        endVisited = new HashSet<>();
        beginVisited.add(beginWord);
        endVisited.add(endWord);

        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            // 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (canTransform2Endword2(word, endWord, nextLevelVisited))
                    return step + 1;
            }
            // 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }
    private boolean canTransform2Endword2(String curWord, String endWord, Set<String> nextLevelVisited) {
        char[] chars = curWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char originChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originChar)
                    continue;
                chars[i] = c;
                String nextWord = new String(chars);
                if (wordSet.contains(nextWord)) {
                    if (endVisited.contains(nextWord))
                        return true;
                    if (!visited.contains(nextWord)) {
                        // 加进新一层的集合里
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            chars[i] = originChar;
        }
        return false;
    }
}
