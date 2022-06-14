package multiPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int width = r - l;
            if (height[l] < height[r]) {
                max = Math.max(max, width * height[l]);
                l++;
            } else {
                max = Math.max(max, width * height[r]);
                r--;
            }
        }
        return max;
    }
}
