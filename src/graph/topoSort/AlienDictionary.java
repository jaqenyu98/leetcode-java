package graph.topoSort;

import java.util.*;

public class AlienDictionary {
    /*----------------------------------------------bfs-------------------------------------------*/
    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> indegrees = new HashMap<>();

    public String alienOrder(String[] words) {
        // map图的初始化
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                // 每个顶点都要有一个list，即使这个list是空的，没有边和它相连。
                graph.putIfAbsent(word.charAt(i), new ArrayList<>());
            }
        }
        // 建图，填充indegrees
        for (int i = 0; i < words.length - 1; i++) {
            String small = words[i];
            String large = words[i + 1];
            int index = 0;
            int minLen = Math.min(small.length(), large.length());
            while (index < minLen) {
                char charSmall = small.charAt(index);
                char charLarge = large.charAt(index);
                if (charSmall != charLarge) {
                    graph.get(charSmall).add(charLarge);
                    indegrees.put(charLarge, indegrees.getOrDefault(charLarge, 0) + 1);
                    break;
                }
                index++;
            }
            // ["abc", "ab"] 非法，返回""
            if (index == minLen && small.length() > large.length())
                return "";
        }
        Queue<Character> queue = new LinkedList<>();
        Set<Character> vertices = graph.keySet();
        // 不在indegrees里的入度为0，入队
        for (Character vertex : vertices) {
            //indegrees里的元素入度都是大于0的，不在里面的都是0！
            if (!indegrees.containsKey(vertex))
                queue.offer(vertex);
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            Character cur = queue.poll();
            result.append(cur);
            for (Character next : graph.get(cur)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0)
                    queue.offer(next);
            }
        }
        // ["a","b","c","b"] 非法，返回""
        return result.length() == graph.size() ? result.toString() : "";
    }
    /*----------------------------------------------dfs-------------------------------------------*/
    // Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> visited = new HashMap<>();
    StringBuilder res = new StringBuilder();
    public String alienOrder2(String[] words){
        // map图的初始化
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                // 每个顶点都要有一个list，即使这个list是空的，没有边和它相连。
                graph.putIfAbsent(word.charAt(i), new ArrayList<>());
                visited.putIfAbsent(word.charAt(i), 0);
            }
        }
        // 建图
        for (int i = 0; i < words.length - 1; i++) {
            String small = words[i];
            String large = words[i + 1];
            int index = 0;
            int minLen = Math.min(small.length(), large.length());
            while (index < minLen) {
                char charSmall = small.charAt(index);
                char charLarge = large.charAt(index);
                if (charSmall != charLarge) {
                    graph.get(charSmall).add(charLarge);
                    break;
                }
                index++;
            }
            // ["abc", "ab"] 非法，返回""
            if (index == minLen && small.length() > large.length())
                return "";
        }
        Set<Character> vertices = graph.keySet();
        for (Character vertex : vertices) {
            if (hasCycle(vertex))
                return "";
        }
        return res.reverse().toString();
    }
    private boolean hasCycle(Character cur) {
        if (visited.get(cur) == 1)
            return true;
        if (visited.get(cur) == 2)
            return false;
        visited.put(cur, 1);
        for (Character next : graph.get(cur)) {
            if (hasCycle(next))
                return true;
        }
        visited.put(cur, 2);
        res.append(cur);
        return false;
    }
}
