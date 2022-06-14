package multiPointers;

import java.util.*;

public class IntersectionOfArrays {
    /*----------------------------------------------349题--------------------------------------------------*/
    /*------------------hashset解法-------------------*/
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                resSet.add(i);
            }
        }
        int[] result = new int[resSet.size()];
        int i = 0;
        for (int num : resSet) {
            result[i++] = num;
        }
        return result;
    }
    /*------------------排序+双指针解法-------------------*/
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        Set<Integer> resSet = new HashSet<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                resSet.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] result = new int[resSet.size()];
        int i = 0;
        for (int num : resSet) {
            result[i++] = num;
        }
        return result;
    }
    /*----------------------------------------------350题--------------------------------------------------*/
    /*------------------hashmap解法-------------------*/
    public int[] intersect3(int[] nums1, int[] nums2) {
        // 妙啊，这样nums1就一定是长度较短的数组，为短数组创建map减小空间复杂度。
        if (nums1.length > nums2.length) {
            return intersect3(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resArr = new ArrayList<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                resArr.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] result = new int[resArr.size()];
        int i = 0;
        for (int num : resArr) {
            result[i++] = num;
        }
        return result;
    }
    /*------------------排序+双指针解法-------------------*/
    public int[] intersect4(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> resArr = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                resArr.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] result = new int[resArr.size()];
        int i = 0;
        for (int num : resArr) {
            result[i++] = num;
        }
        return result;
    }
}
