package binaryTree;

import java.util.*;

public class LowestCommonAncestor {
    /*--------------------------------------------------map法--------------------------------------------------*/
    /*----------------------------bfs--------------------------*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                map.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        TreeNode ancestor = p;
        while (ancestor != null) {
            set.add(ancestor);
            ancestor = map.get(ancestor);
        }
        ancestor = q;
        while (ancestor != null) {
            if (set.contains(ancestor))
                return ancestor;
            ancestor = map.get(ancestor);
        }
        return null;
    }
    /*----------------------------dfs--------------------------*/
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        TreeNode ancestor = p;
        while (ancestor != null) {
            visited.add(ancestor);
            ancestor = parent.get(ancestor);
        }
        ancestor = q;
        while (ancestor != null) {
            if (visited.contains(ancestor))
                return ancestor;
            ancestor = parent.get(ancestor);
        }
        return null;
    }
    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(root.right);
        }
    }
    /*--------------------------------------------------Iteration--------------------------------------------------*/
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return root;
        }
    }
}
