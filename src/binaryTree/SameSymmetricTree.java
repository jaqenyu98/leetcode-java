package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SameSymmetricTree {
    /*--------------------------------------------------100题--------------------------------------------------*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == null && q == null;
        boolean result = isSameTree(p.left, q.left);
        result &= p.val == q.val;
        result &= isSameTree(p.right, q.right);
        return result;
    }
    /*--------------------------------------------------101题--------------------------------------------------*/
    /*-----------------------递归---------------------*/
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == null && q == null;
        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
    /*-----------------------迭代---------------------*/
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p != null && q != null) {
                if (p.val != q.val)
                    return false;
                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(p.right);
                queue.offer(q.left);
            } else if (p != null || q != null) {
                return false;
            }
        }
        return true;
    }
}
