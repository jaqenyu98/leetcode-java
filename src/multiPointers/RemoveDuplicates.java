package multiPointers;

public class RemoveDuplicates {
    /*----------------------------------------------最多重复k次的通用解法--------------------------------------------------*/
    public int removeDuplicates(int[] nums, int k) {
        int n = nums.length;
        if (n <= k)
            return n;
        // 慢指针表示待赋值的位置
        int slow = k;
        // 快指针表示扫描的位置
        int fast = k;
        while (fast < n) {
            // 数组有序，所以只需比较两端的
            if (nums[slow - k] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
