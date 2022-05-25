package binarySearch;

public class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int firstPos = findFirstPosition(nums, target);
        int lastPos = findLastPosition(nums, target);
        return new int[]{firstPos, lastPos};
    }
    private int findFirstPosition(int[] nums, int target) {
        // [l, r)
        int l = 0;
        int r = nums.length;
        boolean hasTarget = false;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                hasTarget = true;
                r = mid;
            }
        }
        // 如果不存在target，循环结束的条件是l = r = target该插入的地方
        if (!hasTarget)
            return -1;
        //如果存在target，循环结束的条件是l = r = mid = target，所以这里返回l或者r都对。
        return l;
    }
    private int findLastPosition(int[] nums, int target) {
        // [l, r)
        int l = 0;
        int r = nums.length;
        boolean hasTarget = false;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                hasTarget = true;
                l = mid + 1;
            }
        }
        // 如果不存在target，循环结束的条件是l = r = target该插入的地方
        if (!hasTarget)
            return -1;
        //如果存在target，循环结束的条件是l = r = mid + 1, mid = target，所以这里返回l - 1 或者 r - 1都对。
        return l - 1;
    }
}
