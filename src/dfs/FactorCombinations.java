package dfs;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2);
        return result;
    }
    private void dfs(int n, int start) {
        int end = (int)Math.sqrt(n);
        for (int i = start; i <= end; i++) {
            if (n % i == 0) {
                int j = n / i;
                path.add(i);
                path.add(j);
                // 在这里add进result
                result.add(new ArrayList<>(path));
                // add完先remove一个是关键
                path.remove(path.size() - 1);
                dfs(n / i, i);
                // dfs完再remove一个
                path.remove(path.size() - 1);
            }
        }
    }
}
