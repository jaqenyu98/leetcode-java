package graph.topoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    /*-------------------------------------------------------------------207题--------------------------------------------------------------------------*/
    /*----------------------------------------------dfs-------------------------------------------*/
    List<List<Integer>> graph;
    // 0: undiscovered; 1: discovered; 2: finished
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(hasCycle(i))
                return false;
        }
        return true;
    }
    private boolean hasCycle(int cur) {
        // 如果discover还未finish的节点，再次被访问，则存在环
        if (visited[cur] == 1)
            return true;
        if (visited[cur] == 2)
            return false;
        visited[cur] = 1;
        for (int next : graph.get(cur)) {
            if (hasCycle(next))
                return true;
        }
        visited[cur] = 2;
        return false;
    }
    /*----------------------------------------------bfs-------------------------------------------*/
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] courses : prerequisites) {
            int from = courses[1];
            int to = courses[0];
            graph.get(from).add(to);
            indegrees[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                queue.offer(i);
        }
        int numTopoOrder = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            numTopoOrder++;
            for (int next : graph.get(cur)) {
                indegrees[next]--;
                if (indegrees[next] == 0)
                    queue.offer(next);
            }
        }
        return numTopoOrder == numCourses;
    }
    /*-------------------------------------------------------------------210题--------------------------------------------------------------------------*/
    /*----------------------------------------------dfs-------------------------------------------*/
    // 207题声明了，这里就先注释掉了。
    // List<List<Integer>> graph;
    // int[] visited;
    int[] result;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];
        index = numCourses - 1;
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!canFinish(i))
                return new int[0];
        }
        return result;
    }
    private boolean canFinish(int cur) {
        if (visited[cur] == 1)
            return false;
        if (visited[cur] == 2)
            return true;
        visited[cur] = 1;
        for (int next : graph.get(cur)) {
            if (!canFinish(next))
                return false;
        }
        visited[cur] = 2;
        result[index--] = cur;
        return true;
    }
    /*----------------------------------------------bfs-------------------------------------------*/
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
            indegrees[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                queue.offer(i);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[index++] = cur;
            for (int next : graph.get(cur)) {
                indegrees[next]--;
                if (indegrees[next] == 0)
                    queue.offer(next);
            }
        }
        return index == numCourses ? result : new int[]{};
    }
}
