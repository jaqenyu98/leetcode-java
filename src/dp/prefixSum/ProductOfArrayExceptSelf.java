package dp.prefixSum;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }
}
