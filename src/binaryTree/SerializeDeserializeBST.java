package binaryTree;

public class SerializeDeserializeBST {
    StringBuilder sb = new StringBuilder();
    public String serialize(TreeNode root) {
        dfsSerialize(root);
        return sb.toString();
    }
    private void dfsSerialize(TreeNode root) {
        if (root == null)
            return;
        sb.append(root.val + ",");
        dfsSerialize(root.left);
        dfsSerialize(root.right);
    }

    public TreeNode deserialize(String data) {
        if ("".equals(data))
            return null;
        // 不用管最后的逗号，直接分割就行。
        String[] strs = data.split(",");
        return dfsDeserialize2(strs, 0, strs.length - 1);
    }
    private TreeNode dfsDeserialize(String[] strs, int left, int right) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(strs[left]));
        int idx = left + 1;
        while (idx <= right && node.val > Integer.parseInt(strs[idx]))
            idx++;
        node.left = dfsDeserialize(strs, left + 1, idx - 1);
        node.right = dfsDeserialize(strs, idx, right);
        return node;
    }
    // 二分优化
    private TreeNode dfsDeserialize2(String[] strs, int left, int right) {
        if (left > right)
            return null;
        int l = left + 1;
        int r = right;
        int target = Integer.parseInt(strs[left]);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (Integer.parseInt(strs[mid]) > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        TreeNode node = new TreeNode(target);
        node.left = dfsDeserialize2(strs, left + 1, r);
        node.right = dfsDeserialize2(strs, l, right);
        return node;
    }
}
