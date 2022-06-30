package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Traversal {
    /*--------------------------------------------------Recursion--------------------------------------------------*/
    List<Integer> inorder;
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder = new ArrayList<>();
        traversal(root);
        return inorder;
    }
    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        inorder.add(root.val);
        traversal(root.right);
    }
    /*--------------------------------------------------Iteration--------------------------------------------------*/
    /*----------------------------inorder--------------------------*/
    // 左中右
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                // 先push右
                if (node.right != null)
                    stack.push(node.right);
                // 在待处理节点前加一个null来标记，遇到null就知道下一个是待处理节点了。
                // 将左节点放在待处理节点后push，意味着左节点永远在当前节点的栈顶，也就实现了递归思想中的先左再中最后右。
                stack.push(node);
                stack.push(null);
                // 再push左
                if (node.left != null)
                    stack.push(node.left);
            } else {
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
    /*----------------------------preorder--------------------------*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
                stack.push(node);
                stack.push(null);
            } else {
                node = stack.pop();
                preorder.add(node.val);
            }
        }
        return preorder;
    }
    /*----------------------------postorder--------------------------*/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            } else {
                node = stack.pop();
                postorder.add(node.val);
            }
        }
        return postorder;
    }


}

