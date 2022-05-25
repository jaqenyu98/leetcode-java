package multiPointers;

import java.util.Random;

public class KthLargestElement {
    /*----------------------------------------------快排解法--------------------------------------------------*/
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;
        // 妙啊！还有二分法的思想在里面！
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex > target) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        // all in [left, l] <= pivot
        // all in [r, right] >= pivot
        int l = left + 1;
        int r = right;
        while (true) {
            while (l <= right && nums[l] < pivot) {
                l++;
            }
            while (r > left && nums[r] > pivot) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
                l++;
                r--;
            } else {
                break;
            }
        }
        swap(nums, left, r);
        return r;
    }

    /*----------------------------------------------堆排解法--------------------------------------------------*/
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, len);
        }
        for (int i = len - 1; i > len - k; i--) {
            swap(nums, 0, i);
            siftDown(nums, 0, i);
        }
        return nums[0];
    }

    private void siftDown(int[] nums, int cur, int len) {
        int leftChild = 2 * cur + 1;
        int rightChild = 2 * cur + 2;
        int maxIndex = cur;
        if (rightChild < len && nums[maxIndex] < nums[rightChild]) {
            maxIndex = rightChild;
        }
        if (leftChild < len && nums[maxIndex] < nums[leftChild]) {
            maxIndex = leftChild;
        }
        if (maxIndex != cur) {
            swap(nums, maxIndex, cur);
            siftDown(nums, maxIndex, len);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
