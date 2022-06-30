package dfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null)
            dfs(root, String.valueOf(root.val));
        return result;
    }
    private void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + "->" + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, path + "->" + root.right.val);
        }
    }
}
