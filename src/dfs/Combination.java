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

    /*剪枝优化*/
    public List<List<Integer>> combinationSumPrune(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfsPrune(candidates, ans, path, target, 0);
        return ans;
    }
    private void dfsPrune(int[] candidates, List<List<Integer>> ans, List<Integer> path, int target, int startIndex) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //for循环这加了个条件，减少了操作次数
        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            dfsPrune(candidates, ans, path, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
    /*------------------------------------------40题--------------------------------------------------------*/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs2(candidates, result, path, target, 0);
        return result;
    }
    private void dfs2(int[] candidates, List<List<Integer>> result, List<Integer> path, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            //去重
            if (i > startIndex && candidates[i] == candidates[i-1])
                continue;
            path.add(candidates[i]);
            //最后一项是i+1，保证每个元素只用一次
            dfs2(candidates, result, path, target - candidates[i], i+1);
            path.remove(path.size() - 1);
        }
    }
    /*------------------------------------------77题--------------------------------------------------------*/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs3(result, path, 1, n, k);
        return result;
    }
    private void dfs3(List<List<Integer>> result, List<Integer> path, int startIndex, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //n - i + 1 >= k剪枝优化
        for (int i = startIndex; i <= n && n - i + 1 >= k; i++) {
            path.add(i);
            dfs3(result, path, i + 1, n, k - 1);
            path.remove(path.size() - 1);
        }
    }
    /*------------------------------------------78题--------------------------------------------------------*/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs4(nums, result, path, 0);
        return result;
    }
    private void dfs4(int[] nums, List<List<Integer>> result, List<Integer> path, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs4(nums, result, path, i + 1);
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
