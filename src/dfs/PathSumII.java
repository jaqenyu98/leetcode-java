package dfs;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    /*--------------------------------------------------dfs写法--------------------------------------------------*/
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(binaryTree.TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }
    private void dfs(TreeNode root, int targetSum) {
        if (root == null)
            return;
        targetSum -= root.val;
        path.add(root.val);
        if (targetSum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.remove(path.size() - 1);
    }
    /*--------------------------------------------------回溯写法--------------------------------------------------*/
    // List<List<Integer>> result = new ArrayList<>();
    // List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        if (root != null) {
            path.add(root.val);
            dfs2(root, targetSum - root.val);
        }
        return result;
    }
    private void dfs2(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            dfs2(root.left, targetSum - root.left.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            dfs2(root.right, targetSum - root.right.val);
            path.remove(path.size() - 1);
        }
    }
}
