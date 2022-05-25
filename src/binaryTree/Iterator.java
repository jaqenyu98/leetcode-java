package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Iterator {
    private int idx;
    private List<Integer> arr;

    public Iterator(TreeNode root) {
        idx = 0;
        arr = new ArrayList<>();
        inorderTraversal(root, arr);
    }

    public int next(){
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr){
        if(root==null)
            return;
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }

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
