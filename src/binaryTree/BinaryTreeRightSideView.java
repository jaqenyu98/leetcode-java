package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (i == size - 1)
                    result.add(node.val);
            }
        }
        return result;
    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth == result.size())
            result.add(root.val);
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
