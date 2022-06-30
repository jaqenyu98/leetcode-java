package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    /*----------------------------------------------bfs-------------------------------------------*/
    // Encodes a tree to a single multiPointers.string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null");
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (index < strings.length) {
            TreeNode node = queue.poll();
            String leftChild = strings[index++];
            String rightChild = strings[index++];
            if (!"null".equals(leftChild)) {
                node.left = new TreeNode(Integer.parseInt(leftChild));
                queue.offer(node.left);
            }
            if (!"null".equals(rightChild)) {
                node.right = new TreeNode(Integer.parseInt(rightChild));
                queue.offer(node.right);
            }
        }
        return root;
    }
    /*----------------------------------------------dfs-------------------------------------------*/
    public String serialize2(TreeNode root) {
        if (root == null)
            return "null";
        return root.val + "," + serialize2(root.left) + "," + serialize2(root.right);
    }
    int idx = 0;
    public TreeNode deserialize2(String data) {
        String[] strs = data.split(",");
        return dfs(strs);
    }
    private TreeNode dfs(String[] strs) {
        String str = strs[idx];
        if ("null".equals(str)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        idx++;
        node.left = dfs(strs);
        idx++;
        node.right = dfs(strs);
        return node;
    }
}
