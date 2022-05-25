package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder result = new StringBuilder();
        result.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            //队首出队
            TreeNode node = queue.poll();
            if (node != null) {
                //处理队首
                result.append(node.val);
                //左子入队
                queue.offer(node.left);
                //右子入队
                queue.offer(node.right);
            } else {
                result.append("null");
            }
            result.append(",");
        }
        result.append("]");
        return result.toString();
    }
    public TreeNode deserialize(String data) {
        if ("".equals(data))
            return null;
        String[] dataList = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(dataList[i])) {
                node.left = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(dataList[i])) {
                node.right = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.right);
            }
            i++;
        }
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
