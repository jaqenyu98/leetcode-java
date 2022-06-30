package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromTraversal {
    /*--------------------------------------------------105题--------------------------------------------------*/
    //前序+中序：中左右+左中右
    Map<Integer, Integer> inorderIndices;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        inorderIndices = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndices.put(inorder[i], i);
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    // 返回的是建好的树的root
    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderFirst, int preorderLast, int inorderFirst, int inorderLast) {
        // if (preorderFirst > preorderLast) 也行，都证明没有左右子树了
        if (inorderFirst > inorderLast)
            return null;
        TreeNode root = new TreeNode(preorder[preorderFirst]);
        int inorderRoot = inorderIndices.get(preorder[preorderFirst]);
        int leftTreeSize = inorderRoot - inorderFirst;
        root.left = buildTree(preorder, inorder, preorderFirst + 1, preorderFirst + leftTreeSize, inorderFirst, inorderRoot - 1);
        root.right = buildTree(preorder, inorder, preorderFirst + leftTreeSize + 1, preorderLast, inorderRoot + 1, inorderLast);
        return root;
    }
    /*--------------------------------------------------106题--------------------------------------------------*/
    // 中序+后序
    // Map<Integer, Integer> inorderIndices;
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int n = inorder.length;
        inorderIndices = new HashMap<>();
        for (int i = 0; i < n; i++)
            inorderIndices.put(inorder[i], i);
        return buildTree2(inorder, postorder, 0, n - 1, 0, n - 1);
    }
    private TreeNode buildTree2(int[] inorder, int[] postorder, int inorderFirst, int inorderLast, int postorderFirst, int postorderLast) {
        if (inorderFirst > inorderLast)
            return null;
        TreeNode root = new TreeNode(postorder[postorderLast]);
        int inorderRoot = inorderIndices.get(postorder[postorderLast]);
        int leftTreeSize = inorderRoot - inorderFirst;
        root.left = buildTree2(inorder, postorder, inorderFirst, inorderRoot - 1, postorderFirst, postorderFirst + leftTreeSize - 1);
        root.right = buildTree2(inorder, postorder, inorderRoot + 1, inorderLast, postorderFirst + leftTreeSize, postorderLast - 1);
        return root;
    }
    /*--------------------------------------------------889题--------------------------------------------------*/
    Map<Integer, Integer> postorderIndices;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        postorderIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            postorderIndices.put(postorder[i], i);
        }
        return build(preorder, postorder, 0, n - 1, 0, n - 1);
    }
    private TreeNode build(int[] preorder, int[] postorder, int preorderFirst, int preorderLast, int postorderFirst, int postorderLast) {
        if (preorderFirst > preorderLast)
            return null;
        TreeNode root = new TreeNode(preorder[preorderFirst]);
        // 如果preorderFirst后面没东西了，返回。
        if (preorderFirst == preorderLast)
            return root;
        int leftTreeRoot = postorderIndices.get(preorder[preorderFirst + 1]);
        int leftTreeSize = leftTreeRoot - postorderFirst + 1;
        root.left = build(preorder, postorder, preorderFirst + 1, preorderFirst + leftTreeSize, postorderFirst, leftTreeRoot);
        root.right = build(preorder, postorder, preorderFirst + leftTreeSize + 1, preorderLast,leftTreeRoot + 1, postorderLast);
        return root;
    }
}

