package binaryTree;

public class InorderSuccessorInBST {
    TreeNode successor = null;
    TreeNode prev = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        inorderSuccessor(root.left, p);
        // 这是关键
        if (prev == p) {
            successor = root;
        }
        prev = root;
        inorderSuccessor(root.right, p);
        return successor;
    }
}
