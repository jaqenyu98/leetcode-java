package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    /*----------------------------------------------bfs-------------------------------------------*/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            // 要在头部插入，用链表比数组更快
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 1)
                    temp.add(0, node.val);
                else
                    temp.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(temp);
            level++;
        }
        return result;
    }

    /*----------------------------------------------dfs-------------------------------------------*/
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;
        if (result.size() == level)
            // 要在头部插入，用链表比数组更快
            result.add(new LinkedList<>());
        if (level % 2 == 1)
            result.get(level).add(0, root.val);
        else
            result.get(level).add(root.val);
        dfs(result, root.left, level + 1);
        dfs(result, root.right, level + 1);
    }
}
