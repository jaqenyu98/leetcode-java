package bfs;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    /*-----------------------------------------------------------102题------------------------------------------------------------*/
    /*----------------------------------------------bfs-------------------------------------------*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 别忘了这里判断null
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(temp);
        }
        return result;
    }

    /*----------------------------------------------dfs-------------------------------------------*/
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;
        if (result.size() == level)
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(result, root.left, level + 1);
        dfs(result, root.right, level + 1);
    }

    /*-----------------------------------------------------------107题------------------------------------------------------------*/
    /*----------------------------------------------bfs-------------------------------------------*/
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 别忘了这里判断null
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(0, temp);
        }
        return result;
    }

    /*----------------------------------------------dfs-------------------------------------------*/
    public List<List<Integer>> levelOrder4(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        dfs2(result, root, 0);
        return result;
    }

    private void dfs2(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;
        if (result.size() == level){
            // 1. 新list加在头部
            result.add(0, new ArrayList<>());
        }
        // 2. 反过来，第0层的在最后面，最下层的在最前面。
        result.get(result.size() - level - 1).add(root.val);
        dfs2(result, root.left, level + 1);
        dfs2(result, root.right, level + 1);
    }
}
