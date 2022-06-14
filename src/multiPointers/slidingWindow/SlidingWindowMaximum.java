package multiPointers.slidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
    /*---------------------------------------堆---------------------------------------*/
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        result[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] < i - k + 1)
                pq.poll();
            result[i - k + 1] = pq.peek()[0];
        }
        return result;
    }
    /*---------------------------------------单调队列---------------------------------------*/
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> monoQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!monoQueue.isEmpty() && nums[i] > nums[monoQueue.peekLast()])
                monoQueue.pollLast();
            monoQueue.offerLast(i);
            if (monoQueue.peekFirst() < i - k + 1)
                monoQueue.pollFirst();
            if (i >= k - 1)
                result[i - k + 1] = nums[monoQueue.peekFirst()];
        }
        return result;
    }
}
