package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /*------------------------------------------78题--------------------------------------------------------*/
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return result;
    }
    private void dfs(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
    /*------------------------------------------90题--------------------------------------------------------*/
    // List<List<Integer>> result = new ArrayList<>();
    // List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs2(nums, 0);
        return result;
    }
    private void dfs2(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            dfs2(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
