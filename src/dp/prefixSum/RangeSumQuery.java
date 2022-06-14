package dp.prefixSum;

public class RangeSumQuery {
    int[] prefixSum;

    public RangeSumQuery(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
