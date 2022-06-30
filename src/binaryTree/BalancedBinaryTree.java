package binaryTree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        // 一旦有-1的，证明不平衡，直接返回结束递归
        if (leftHeight == -1)
            return -1;
        int rightHeight = height(root.right);
        // 一旦有-1的，证明不平衡，直接返回结束递归
        if (rightHeight == -1)
            return -1;
        return Math.abs(leftHeight - rightHeight) < 2 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}
