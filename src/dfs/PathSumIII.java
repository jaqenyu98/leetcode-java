package dfs;

import java.util.*;

public class PathSumIII {
    /*--------------------------------------------------对每个节点dfs--------------------------------------------------*/
    int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            dfs(node, targetSum - node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return result;
    }
    private void dfs(TreeNode root, int targetSum) {
        // 这里不要return，因为可能后面还有
        if (targetSum == 0) {
            result++;
        }
        if (root.left != null)
            dfs(root.left, targetSum - root.left.val);
        if (root.right != null)
            dfs(root.right, targetSum - root.right.val);
    }
    /*--------------------------------------------------前缀和--------------------------------------------------*/
    // int result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum2(TreeNode root, int targetSum) {
        map.put(0, 1);
        if (root != null)
            dfs2(root, targetSum, root.val);
        return result;
    }
    private void dfs2(TreeNode root, int targetSum, int prefixSum) {
        int goal = prefixSum - targetSum;
        if (map.containsKey(goal)) {
            result += map.get(goal);
        }
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        if (root.left != null) {
            dfs2(root.left, targetSum, prefixSum + root.left.val);
        }
        if (root.right != null) {
            dfs2(root.right, targetSum, prefixSum + root.right.val);
        }
        // 注意要减回去，因为只看从祖先到当前节点这一条分支的。
        map.put(prefixSum, map.get(prefixSum) - 1);
    }
}
