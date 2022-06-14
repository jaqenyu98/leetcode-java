package bfs;

import java.util.Arrays;
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
    public TreeNode deserialize2(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }
    private TreeNode dfs(Queue<String> queue) {
        String str = queue.poll();
        if ("null".equals(str)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }
}
