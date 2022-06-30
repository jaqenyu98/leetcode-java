package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int k = Math.abs(nums[i]);
            if (nums[k - 1] > 0) {
                nums[k - 1] = -nums[k - 1];
            } else {
                result.add(k);
            }
        }
        return result;
    }
    public List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = nums[i] > n ? nums[i] - n : nums[i];
            if (nums[k - 1] > n) {
                result.add(k);
            } else {
                nums[k - 1] += n;
            }
        }
        return result;
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
