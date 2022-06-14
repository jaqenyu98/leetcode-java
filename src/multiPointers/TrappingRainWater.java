package multiPointers;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {
    /*----------------------------------------------按列统计法--------------------------------------------------*/
    public int trap(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMaxHeight = height[i];
            int rightMaxHeight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > rightMaxHeight) {
                    rightMaxHeight = height[j];
                }
            }
            for (int j = i - 1; j >= 0 ; j--) {
                if (height[j] > leftMaxHeight) {
                    leftMaxHeight = height[j];
                }
            }
            int h = Math.min(leftMaxHeight, rightMaxHeight) - height[i];
            if (h > 0)
                result += h;
        }
        return result;
    }
    /*----------------------------------------------动规法--------------------------------------------------*/
    public int trap2(int[] height) {
        int result = 0;
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i + 1], maxRight[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            int h = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (h > 0)
                result += h;
        }
        return result;
    }
    /*----------------------------------------------双指针法--------------------------------------------------*/
    public int trap3(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        while (left < right) {
            if (maxLeft < maxRight) {
                result += Math.max(0, maxLeft - height[left]);
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                result += Math.max(0, maxRight - height[right]);
                right--;
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return result;
    }
    /*----------------------------------------------单调栈法--------------------------------------------------*/
    public int trap4(int[] height) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int right = 0; right < height.length; ++right) {
            while (!stack.isEmpty() && height[right] > height[stack.peek()]) {
                int mid = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int w = right - left - 1;
                int h = Math.min(height[left], height[right]) - height[mid];
                result += w * h;
            }
            stack.push(right);
        }
        return result;
    }
}
