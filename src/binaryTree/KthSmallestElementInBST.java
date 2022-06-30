package binaryTree;

public class KthSmallestElementInBST {
    int result;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorderTraversal(root);
        return result;
    }
    private void inorderTraversal(TreeNode root) {
        // 遍历到第k个直接结束
        if (root == null || k <= 0)
            return;
        inorderTraversal(root.left);
        if (--k == 0)
            result = root.val;
        inorderTraversal(root.right);
    }
}
