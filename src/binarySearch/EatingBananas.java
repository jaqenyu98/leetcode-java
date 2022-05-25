package binarySearch;

public class EatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 1;
        for (int pile: piles) {
            max = Math.max(max, pile);
        }
        int l = 1;
        int r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int timeSum = 0;
            for (int pile: piles) {
                // 手写向上取整更快，Math.ceil还要转为浮点数太慢了
                timeSum += (pile - 1) / mid + 1;
            }
            if (timeSum > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
