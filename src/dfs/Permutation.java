package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        dfs(nums, result, path, isVisited);
        return result;
    }
    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] isVisited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            这两种写法一个意思，下面那种看着顺眼。
//            if (isVisited[i])
//                continue;
//            path.add(nums[i]);
//            isVisited[i] = true;
//            dfs(nums, result, path, isVisited);
//            path.remove(path.size() - 1);
//            isVisited[i] = false;
            if (!isVisited[i]) {
                path.add(nums[i]);
                isVisited[i] = true;
                dfs(nums, result, path, isVisited);
                path.remove(path.size() - 1);
                isVisited[i] = false;
            }
        }
    }
    /*------------------------------------------40题--------------------------------------------------------*/
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        //去重需要排序
        Arrays.sort(nums);
        dfs2(nums, result, path, isVisited);
        return result;
    }
    private void dfs2(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] isVisited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //去重
            if (i != 0 && nums[i] == nums[i - 1] && !isVisited[i - 1])
                continue;
            if (!isVisited[i]) {
                path.add(nums[i]);
                isVisited[i] = true;
                dfs(nums, result, path, isVisited);
                path.remove(path.size() - 1);
                isVisited[i] = false;
            }
        }
    }
}
