package binaryTree;

import java.util.LinkedList;

public class VerifyPreorderSerialization {
    /*--------------------------------------------------栈（消消乐）--------------------------------------------------*/
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        LinkedList<String> stack = new LinkedList<>();
        for (String str : strs) {
            stack.push(str);
            while (stack.size() >= 3 && "#".equals(stack.get(0)) && "#".equals(stack.get(1)) && !"#".equals(stack.get(2))) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && "#".equals(stack.peek());
    }
    /*--------------------------------------------------入度出度--------------------------------------------------*/
    public boolean isValidSerialization2(String preorder) {
        int indegree = 0;
        int outdegree = 0;
        String[] strs = preorder.split(",");
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            // 根节点入度为0，将空节点看作入度1出度0的节点。
            if (i != 0)
                indegree++;
            if (!"#".equals(strs[i]))
                outdegree += 2;
            // 最后一个节点之前有，in + 1 <= out
            if (i != n - 1 && indegree + 1 > outdegree)
                return false;
        }
        // 最后一个节点结束，有 in==out
        return indegree == outdegree;
    }
    /*--------------------------------------------------模拟建树--------------------------------------------------*/
    int idx = 0;
    public boolean isValidSerialization3(String preorder) {
        String[] strs = preorder.split(",");
        dfs3(strs);
        return idx == strs.length - 1;
    }
    private void dfs3(String[] strs) {
        // 返回条件有两个，一个是空节点，一个是idx越界了（证明节点不够）
        if (idx >= strs.length || "#".equals(strs[idx]))
            return;
        idx++;
        dfs3(strs);
        // 一定要写两遍，代表左右子树，因为这样能找出节点不够的情况。
        idx++;
        dfs3(strs);
    }
}
