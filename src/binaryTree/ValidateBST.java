package binaryTree;

public class ValidateBST {
    TreeNode prev = null;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        return isValid;
    }
    private void inorderTraversal(TreeNode root) {
        if (root == null || !isValid)
            return;
        inorderTraversal(root.left);
        if (prev != null && prev.val >= root.val)
            isValid = false;
        prev = root;
        inorderTraversal(root.right);
    }
}
