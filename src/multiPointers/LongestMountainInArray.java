package multiPointers;

public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int result = 0;
        // p1:左山脚，p2山峰，p3右山脚
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while (p1 < arr.length - 1) {
            while (p1 < arr.length - 1 && arr[p1] >= arr[p1 + 1]) {
                p1++;
            }
            p2 = p1;
            while (p2 < arr.length - 1 && arr[p2] < arr[p2 + 1]) {
                p2++;
            }
            p3 = p2;
            while (p3 < arr.length - 1 && arr[p3] > arr[p3 + 1]) {
                p3++;
            }
            // 保证山峰后有下坡
            if (p3 != p2) {
                result = Math.max(result, p3 - p1 + 1);
            }
            p1 = p3;
        }
        return result;
    }
}
