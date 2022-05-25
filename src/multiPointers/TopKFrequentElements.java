package multiPointers;

import java.util.*;

public class TopKFrequentElements {
    /*----------------------------------------------堆排解法--------------------------------------------------*/
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 懒得手写堆了，java里优先队列=堆，直接用
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    /*----------------------------------------------快排解法--------------------------------------------------*/
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);
        int target = list.size() - k;
        int left = 0;
        int right = list.size() - 1;
        while (true) {
            int pivotIndex = partition(list, left, right);
            if (pivotIndex == target) {
                int[] result = new int[k];
                for (int i = 0; i < k; i++) {
                    result[i] = list.get(pivotIndex++).getKey();
                }
                return result;
            } else if (pivotIndex > target) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }
    private int partition(List<Map.Entry<Integer, Integer>> nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        Collections.swap(nums, left, randomIndex);
        int pivot = nums.get(left).getValue();
        // all in [left, l] <= pivot
        // all in [r, right] >= pivot
        int l = left + 1;
        int r = right;
        while (true) {
            while (l <= right && nums.get(l).getValue() < pivot) {
                l++;
            }
            while (r > left && nums.get(r).getValue() > pivot) {
                r--;
            }
            if (l < r) {
                Collections.swap(nums, l, r);
                l++;
                r--;
            } else {
                break;
            }
        }
        Collections.swap(nums, left, r);
        return r;
    }
}
