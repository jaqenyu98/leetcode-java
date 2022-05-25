package binarySearch;

public class RotatedSortedArray {
    /*------------------------------------------------33题-----------------------------------------*/
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {
                // 如果target在左边
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid;
                    // 否则，target在右边
                } else {
                    l = mid + 1;
                }
                // 如果右边是递增的
            } else {
                // 如果target在右边。注意是r-1
                if (nums[mid] < target && target <= nums[r - 1]) {
                    l = mid + 1;
                    // 否则，target在左边
                } else {
                    r = mid;
                }
            }
        }
        return -1;
    }

    /*------------------------------------------------81题-----------------------------------------*/
    public boolean search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
                // 如果是[3,0,3,3,3]，无法判断那边递增，只能缩短区间，排除俩干扰项
            } else if (nums[l] == nums[mid] && nums[mid] == nums[r - 1]) {
                ++l;
                --r;
                // 如果左边是递增的。注意有等号，防止左边只有一个元素。
            } else if (nums[l] <= nums[mid]) {
                // 如果target在左边
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid;
                    // 否则，target在右边
                } else {
                    l = mid + 1;
                }
                // 如果右边是递增的
            } else {
                // 如果target在右边。注意是r-1
                if (nums[mid] < target && target <= nums[r - 1]) {
                    l = mid + 1;
                    // 否则，target在左边
                } else {
                    r = mid;
                }
            }
        }
        return false;
    }
}
