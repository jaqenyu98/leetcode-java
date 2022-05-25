package sort;

public class MergeSort {
    public void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        divideMerge(nums, temp, 0, nums.length - 1);
    }

    private void divideMerge(int[] nums, int[] temp, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        divideMerge(nums, temp, left, mid);
        divideMerge(nums, temp, mid + 1, right);
        //三指针，l r cur
        int l = left;
        int r = mid + 1;
        int cur = left;
        temp = nums.clone();
        while (l <= mid || r <= right) {
            if (l > mid) {
                nums[cur++] = temp[r++];
            } else if (r > right) {
                nums[cur++] = temp[l++];
            } else if (temp[l] < temp[r]) {
                nums[cur++] = temp[l++];
            } else {
                nums[cur++] = temp[r++];
            }
        }
    }
}
