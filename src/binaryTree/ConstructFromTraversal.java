package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructFromTraversal {
    //前序+中序：中左右+左中右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n-1, 0, n-1, indexMap);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight,
                               int inorderLeft, int inorderRight, Map<Integer, Integer> indexMap) {
        if (preorderLeft>preorderRight)
            return null;
        int preorderRoot = preorderLeft;
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        root.left = buildTree(preorder, inorder, preorderLeft+1, preorderLeft+sizeLeftSubtree, inorderLeft, inorderRoot-1, indexMap);
        root.right = buildTree(preorder, inorder, preorderLeft+sizeLeftSubtree+1, preorderRight, inorderRoot+1, inorderRight, indexMap);
        return root;
    }

    /*--------------------------------------------------------------------------------------------------*/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

