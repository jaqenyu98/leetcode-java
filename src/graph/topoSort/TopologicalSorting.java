package graph.topoSort;

import graph.GraphNode;

import java.util.*;

public class TopologicalSorting {
    /*----------------------------------------------dfs-------------------------------------------*/
    ArrayList<GraphNode> result = new ArrayList<>();
    Set<GraphNode> visited = new HashSet<>();
    public ArrayList<GraphNode> topSort(ArrayList<GraphNode> graph) {
        for (GraphNode node : graph) {
            dfs(node);
        }
        Collections.reverse(result);
        return result;
    }
    private void dfs(GraphNode node) {
        if (!visited.contains(node))
            return;
        visited.add(node);
        for (GraphNode neighbor : node.neighbors) {
            dfs(neighbor);
        }
        result.add(node);
    }
    /*----------------------------------------------bfs-------------------------------------------*/
    public ArrayList<GraphNode> topSort2(ArrayList<GraphNode> graph){
        ArrayList<GraphNode> res = new ArrayList<>();
        Map<GraphNode, Integer> indegrees = getIndegrees(graph);
        Queue<GraphNode> queue = new LinkedList<>();
        // 初始入口加入queue
        for (GraphNode node : graph) {
            if (indegrees.get(node) == 0)
                queue.offer(node);
        }
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            res.add(node);
            for (GraphNode neighbor : node.neighbors) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0)
                    queue.offer(neighbor);
            }
        }
        return res;
    }
    private Map<GraphNode, Integer> getIndegrees(ArrayList<GraphNode> graph) {
        Map<GraphNode, Integer> indegrees = new HashMap<>();
        for (GraphNode node : graph) {
            indegrees.put(node, 0);
        }
        for (GraphNode node : graph) {
            for (GraphNode neighbor : node.neighbors) {
                indegrees.put(neighbor, indegrees.get(neighbor) + 1);
            }
        }
        return indegrees;
    }
}
