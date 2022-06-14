package graph;

import java.util.*;

public class CloneGraph {
    /*----------------------------------------------bfs-------------------------------------------*/
    public GraphNode cloneGraph(GraphNode root) {
        if (root == null)
            return null;
        Map<GraphNode, GraphNode> visited = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(root);
        visited.put(root, new GraphNode(root.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            for (GraphNode neighbor: node.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new GraphNode(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                visited.get(node).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(root);
    }
    /*----------------------------------------------dfs-------------------------------------------*/
    Map<GraphNode, GraphNode> visited = new HashMap<>();
    public GraphNode dfs(GraphNode root) {
        if (root == null)
            return null;
        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(root))
            return visited.get(root);
        // 克隆当前节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        GraphNode clonedNode = new GraphNode(root.val, new ArrayList<>());
        // 将当前节点和克隆节点加入visited
        visited.put(root, clonedNode);
        // 遍历它的所有邻居节点,并更新它的邻居列表
        for (GraphNode neighbor : root.neighbors) {
            clonedNode.neighbors.add(dfs(neighbor));
        }
        // 返回邻居列表更新好了的克隆节点
        return clonedNode;
    }
}
