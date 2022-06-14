package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Traversal {
    public List<Integer> traversalRecusive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursive(root, result);
        return result;
    }

    /*------------------------------------------------inorder-----------------------------------------*/
    /*----------------Recursive------------------*/
    private void inorderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        inorderTraversalRecursive(node.left, result);
        result.add(node.val);
        inorderTraversalRecursive(node.right, result);
    }

    /*----------------Iterate------------------*/
    public List<Integer> inorderTraversalIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /*------------------------------------------------preorder-----------------------------------------*/
    /*----------------Recursive------------------*/
    private void preorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        preorderTraversalRecursive(root.left, result);
        preorderTraversalRecursive(root.right, result);
    }

    /*----------------Iterate------------------*/
    public List<Integer> preorderTraversalIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    /*------------------------------------------------postorder-----------------------------------------*/
    /*----------------Recursive------------------*/
    private void postorderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        postorderTraversalRecursive(node.left, result);
        postorderTraversalRecursive(node.right, result);
        result.add(node.val);
    }

    /*----------------Iterate------------------*/
    public List<Integer> postorderTraversalIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //  没有右子树 or 右子树访问过了(或者说root.right是先前遍历过的节点prev)
            if (root.right == null || root.right == prev) {
                //把根加进去
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                //否则 访问右子树
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

}

