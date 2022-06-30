package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        // 这里一定是Integer.MIN_VALUE，而不是nums[0]
        dfs(nums, 0, Integer.MIN_VALUE);
        return result;
    }
    private void dfs(int[] nums, int startIndex, int prev) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        // 用set同层去重
        Set<Integer> visited = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 递归树同一层出现过的数字，不能再次使用！
            if (!visited.contains(nums[i]) && nums[i] >= prev) {
                visited.add(nums[i]);
                path.add(nums[i]);
                dfs(nums, i + 1, nums[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
