package dp.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int len = nums.length;
        // 直接用滚动变量了
        int prefixSum = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < len; i++) {
            prefixSum = prefixSum + nums[i];
            // 先找再put
            int target = prefixSum - k;
            if (hm.containsKey(target))
                result += hm.get(target);
            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}
