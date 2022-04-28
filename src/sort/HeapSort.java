package sort;

public class HeapSort {
    public static void heapSort(int[] nums) {
        int len = nums.length;
        //建最大堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            siftDownIterative(nums, i, len);
        }
        //提取堆顶元素
        for (int i = len - 1; i >= 1; i--) {
            swap(nums, 0, i);
            siftDownIterative(nums, 0, i);
        }
    }

    //递归写法
    private static void siftDownRecursive(int[] nums, int cur, int len) {
        int leftChild = 2 * cur + 1;
        int rightChild = 2 * cur + 2;
        int maxIndex = cur;
        if (rightChild < len && nums[cur] < nums[rightChild])
            maxIndex = rightChild;
        if (leftChild < len && nums[maxIndex] < nums[leftChild])
            maxIndex = leftChild;
        if (maxIndex != cur) {
            swap(nums, cur, maxIndex);
            siftDownRecursive(nums, maxIndex, len);
        }
    }

    //迭代写法
    private static void siftDownIterative(int[] nums, int cur, int len) {
        while (2 * cur + 1 < len) {
            int leftChild = 2 * cur + 1;
            int rightChild = 2 * cur + 2;
            int maxIndex = cur;
            if (rightChild < len && nums[cur] < nums[rightChild])
                maxIndex = rightChild;
            if (leftChild < len && nums[maxIndex] < nums[leftChild])
                maxIndex = leftChild;
            if (maxIndex != cur) {
                swap(nums, cur, maxIndex);
                cur = maxIndex;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
