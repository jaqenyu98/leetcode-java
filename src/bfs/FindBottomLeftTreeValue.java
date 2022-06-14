package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    /*----------------------------------------------bfs-------------------------------------------*/
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 亮点一，不新建node直接用root，最后能直接返回。
            root = queue.poll();
            // 亮点二，从右向左层序遍历，最后一个节点即为所求
            if (root.right != null)
                queue.offer(root.right);
            if (root.left != null)
                queue.offer(root.left);
        }
        return root.val;
    }
    /*----------------------------------------------dfs-------------------------------------------*/
    int maxLevel = -1;
    int result;
    public int findBottomLeftValue2(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (level > maxLevel) {
            maxLevel = level;
            result = root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
