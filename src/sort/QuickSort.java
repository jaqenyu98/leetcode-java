package sort;

import java.util.Random;

public class QuickSort {
    /*--------------------------------------------------------hoare，双指针，两个part，速度最快，建议用这个----------------------------------------------------------*/
    public void hoareQuickSort(int[] nums) {
        hoarePartition(nums, 0, nums.length - 1);
    }

    //根据算法导论3的伪代码改写的hoare划分，双边扫描。没有用书上的方法，还是将pivot放在了中间，然后(left, pivotIndex - 1) (pivotIndex + 1, right)这样子去递归。
    private void hoarePartition(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int randomIndex = left + new Random().nextInt(right - left + 1);
        //将pivot放在了最左边（放哪都行，改后面相应代码就行，书上放左边了）
        swap(nums, left, randomIndex);
        int pivot = nums[left];

        // 循环不变量：
        // nums[left, l] <= pivot
        // nums[l+1, r-1] unknown
        // nums[r, right] >= pivot
        // l: last index of <= pivot part, theoretically start from left-1, if so, it should be do{l++;} while(...), but I don't like do while, hence here l starts from left instead of left-1;
        // r: first index of >= pivot part, theoretically start from right+1, if so, it should be do{r--;} while(...), but I don't like do while, hence here r starts from right instead of right+1;
        int l = left + 1;
        int r = right;
        while (true) {
            // 相等也要交换，否则pivot会偏向一边
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
        // r is the pivot index.
        swap(nums, left, r);
        hoarePartition(nums, left, r - 1);
        hoarePartition(nums, r + 1, right);
    }

    /*----------------------------------------------------lomuto，单指针扫描，两个part，速度慢--------------------------------------------------------------*/
    public void lomutoQuickSort(int[] nums) {
        lomutoPartition(nums, 0, nums.length - 1);
    }

    //根据算法导论3改写的lomuto划分，单边扫描
    private void lomutoPartition(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int randomIndex = left + new Random().nextInt(right - left + 1);
        // 将pivot放在最右边，放哪都行，改相应代码就行，书上放最右边了。
        swap(nums, right, randomIndex);
        int pivot = nums[right];

        //循环不变量
        //nums[left, i] <= pivot
        //nums[i+1, j-1] > pivot
        //nums[j, right] unknown part
        //i: last index of <= pivot part, start from left-1
        //j: first index of unknown part, from left to right-1
        //与hoare相比，lomuto只有j指针在移动和比较
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, j, i);
            }
        }
        // i+1 is the pivot index
        swap(nums, right, i + 1);
        lomutoPartition(nums, left, i);
        lomutoPartition(nums, i + 2, right);
    }

    /*--------------------------------------------------------相等元素很多的情况下的quick sort，单指针扫描，三个part，速度比lomuto快点，应该不如hoare-----------------------------------------------------------------*/
    public void threePartsQuickSort(int[] nums) {
        threePartsPartition(nums, 0, nums.length - 1);
    }

    //在lomuto基础上的改进
    private void threePartsPartition(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int randomIndex = left + new Random().nextInt(right - left + 1);
        // 将pivot放在最左边，放哪都行，改相应代码就行，我习惯放左边。
        swap(nums, left, randomIndex);
        int pivot = nums[left];

        //循环不变量
        //nums[left+1, p] < pivot
        //nums[p+1, q-1] == pivot
        //nums[q, r-1] unknown part
        //nums[r, right] > pivot
        //p<=q<=r
        //p: last index of < pivot part
        //q: first index of unknown part, from left+1 to r
        //r: first index of > pivot part
        int p = left;
        int q = left + 1;
        int r = right + 1;
        while (q < r) {
            if (nums[q] < pivot) {
                p++;
                swap(nums, p, q);
                q++;
            } else if (nums[q] == pivot) {
                q++;
            } else {
                r--;
                swap(nums, r, q);
            }
        }
        swap(nums, left, p);
        threePartsPartition(nums, left, p - 1);
        threePartsPartition(nums, r, right);
    }
    /*--------------------------------------------------------另一种递归方法，这样可以获得每次的pivot，解决Top K的问题时很有用！----------------------------------------------------------*/
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + new Random().nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
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
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
