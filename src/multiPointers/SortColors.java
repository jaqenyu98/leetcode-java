package multiPointers;

public class SortColors {
    public void sortColors(int[] nums) {
        // all in [0, lastZero] == 0
        // all in (lastZero, firstUnknown) == 1
        // all in [firstUnkown, firstTwo) is unknown
        // all in [firstTwo, n) == 2
        int lastZero = -1;
        int firstTwo = nums.length;
        int firstUnknown = 0;
        while (firstUnknown < firstTwo) {
            if (nums[firstUnknown] == 0) {
                lastZero++;
                swap(nums, lastZero, firstUnknown);
                firstUnknown++;
            } else if (nums[firstUnknown] == 1) {
                firstUnknown++;
            } else {
                firstTwo--;
                swap(nums, firstTwo, firstUnknown);
            }
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
