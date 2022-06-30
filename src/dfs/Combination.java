package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    /*---------------------------------------39题--------------------------------------------------------*/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, ans, path, target, 0);
        return ans;
    }
    private void dfs(int[] candidates, List<List<Integer>> ans, List<Integer> path, int target, int startIndex) {
        if (target < 0)
            return;
        if (target == 0) {
            //这里一定是new出来！不能直接传path，因为传的是path的地址，path后面会变！
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, ans, path, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

    /*-----------------------剪枝优化--------------------------*/
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs2(candidates, target, 0);
        return result;
    }
    private void dfs2(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (target < candidates[i])
                break;
            path.add(candidates[i]);
            dfs2(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
    /*------------------------------------------40题--------------------------------------------------------*/
    // List<List<Integer>> result = new ArrayList<>();
    // List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs3(candidates, target, 0);
        return result;
    }
    private void dfs3(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1])
                continue;
            path.add(candidates[i]);
            dfs3(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
    /*------------------------------------------77题--------------------------------------------------------*/
    // List<List<Integer>> result = new ArrayList<>();
    // List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine4(int n, int k) {
        dfs4(n, k, 1);
        return result;
    }
    private void dfs4(int n, int k, int start) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 剪枝，别忘了path里的也要加上
            if (path.size() + n - i + 1 < k)
                break;
            path.add(i);
            dfs4(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
    /*------------------------------------------90题--------------------------------------------------------*/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs5(nums, result, path, 0);
        return result;
    }
    private void dfs5(int[] nums, List<List<Integer>> result, List<Integer> path, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1])
                continue;
            path.add(nums[i]);
            dfs5(nums, result, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
