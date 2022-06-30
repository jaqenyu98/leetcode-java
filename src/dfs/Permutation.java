package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // boolean数组记录是否访问过！
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited);
        return result;
    }
    private void dfs(int[] nums, boolean[] visited) {
        // 结束条件是这个！
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
    /*------------------------------------------40题--------------------------------------------------------*/
    // List<List<Integer>> result = new ArrayList<>();
    // List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 去重需要先排序
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs2(nums, visited);
        return result;
    }
    private void dfs2(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]))
                continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs2(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
