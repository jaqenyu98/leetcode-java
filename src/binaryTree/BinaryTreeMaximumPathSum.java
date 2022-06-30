package binaryTree;

public class BinaryTreeMaximumPathSum {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getRootMaxSum(root);
        return result;
    }
    private int getRootMaxSum(TreeNode root) {
        if (root == null)
            return 0;
        // 负的直接不走
        int left = Math.max(getRootMaxSum(root.left), 0);
        int right = Math.max(getRootMaxSum(root.right), 0);
        // 更新result
        result = Math.max(result, left + right + root.val);
        // 返回包含根节点的最大和，注意左子和右子只能选一个！
        return root.val + Math.max(left, right);
    }
}
