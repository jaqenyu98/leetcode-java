import array.ThreeSum;
import bfs.SerializeDeserializeBinaryTree;
import binarySearch.FirstLastPosition;
import dfs.Combination;
import dfs.Permutation;
import dp.Backpack;
import dp.UniquePaths;
import dp.prefixSum.MaximumSubarray;
import dp.prefixSum.SubarraySumEqualsK;
import graph.WordLadder;
import graph.matrix.RottingOranges;
import graph.matrix.TheMaze;
import graph.topoSort.AlienDictionary;
import linkedList.MyLinkedList;
import multiPointers.MultiplyStrings;
import multiPointers.RemoveDuplicates;
import multiPointers.TrappingRainWater;
import multiPointers.slidingWindow.LongestSubstringWithoutRepeatChar;
import multiPointers.slidingWindow.MinimumWindowSubstring;
import multiPointers.slidingWindow.SlidingWindowMaximum;
import multiPointers.slidingWindow.SubarrayProductLessThanK;
import multiPointers.string.LongestPalindromicSubstring;
import org.junit.jupiter.api.Test;
import sort.*;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MyTest {

    @Test
    public void testBubbleSort() {
        int[] nums = {6, 4, 1, 5, 4, 5, 6, 7, 8, 2, 3, 1, 0, -1};
        new BubbleSort().bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void testInsertionSort() {
        int[] nums = {6, 4, 1, 5, 4, 5, 6, 7, 8, 2, 3, 1, 0, -1};
        new InsertionSort().insertionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void testMergeSort() {
        int[] nums = {8, 2, 5, 0, 7, 4, 6, 1};
        new MergeSort().mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void testQuickSort() {
        int[] nums = {8, 2, 5, 0, 7, 4, 6, 1, 1, 1, 1};
        new QuickSort().lomutoQuickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void testHeapSort() {
        int[] nums = {8, 2, 5, 0, 7, 4, 6, 1, 1, 1, 1};
        new HeapSort().heapSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void testCompare() {
        MyLinkedList l = new MyLinkedList();
        l.addAtHead(7);
        l.addAtTail(7);
        l.addAtHead(9);
        l.addAtTail(8);
        l.addAtHead(6);
        l.addAtHead(0);
        l.addAtHead(0);
        l.addAtTail(4);
    }

    @Test
    public void testPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -o1.compareTo(o2));
        pq.add(1);
        pq.add(0);
        pq.add(2);
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

    @Test
    public void testDfsCombination() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new Combination().combinationSumPrune(candidates, target);
        for (List<Integer> rst : result) {
            for (int i : rst) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    @Test
    public void testPermutation() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new Permutation().permute(nums);
        System.out.println("1");
    }

    @Test
    public void testSubsets() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = new Combination().subsetsWithDup(nums);
    }

    @Test
    public void testUniquePaths() {
        int[][] nums = {{0, 0}};
        System.out.println(new UniquePaths().uniquePathsWithObstacles(nums));
    }

    @Test
    public void testBackpack() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        new Backpack().backpack(weight, value, bagsize);
    }

    @Test
    public void testIslands() {
        //System.out.println(new NumberOfIslands().numIslands2(grid));
    }

    @Test
    public void testBinarySearch() {
        int[] nums = {-1, 0, 2, 3, 4};
        int target = 5;
        int[] result = new FirstLastPosition().searchRange(nums, target);
    }

    @Test
    public void testRemoveDuplicates() {
        int[] nums = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums, 2));
    }

    @Test
    public void testTrappingWater() {
        int[] nums = {4, 2, 0, 3, 2, 5};
        System.out.println(new TrappingRainWater().trap2(nums));
    }

    @Test
    public void testMultiplyStrings() {
        System.out.println(new MultiplyStrings().multiply("123", "45"));
    }

    @Test
    public void testPalindrome() {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome2("ababa"));
    }

    @Test
    public void testLongestSubstring() {
        System.out.println(new LongestSubstringWithoutRepeatChar().lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void testMinWindowSubstring() {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void testMaxSlidingWindow() {
        int[] result = new SlidingWindowMaximum().maxSlidingWindow2(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5);
    }

    @Test
    public void testSubarrayProduct() {
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10, 2, 2, 5, 4, 4, 4, 3, 7, 7}, 289));
    }

    @Test
    public void testMaxSubarray() {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testSubarraySumEqualsK() {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{-1, -1, -1}, -1));
    }

    @Test
    public void testThreeSum() {
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    @Test
    public void testSDBST() {
        System.out.println(new SerializeDeserializeBinaryTree().serialize(new SerializeDeserializeBinaryTree().deserialize("[1,2,3,null,null,4,5]")));
    }

    @Test
    public void testAlienDictionary() {
        System.out.println(new AlienDictionary().alienOrder(new String[]{"a", "ab"}));
    }

    @Test
    public void testMaze() {
        int[][] maze = {{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        System.out.println(new TheMaze().hasPath2(maze, new int[]{4, 3}, new int[]{0, 1}));
    }

    @Test
    public void testRottingOranges(){
        System.out.println(new RottingOranges().orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }

    @Test
    public void testWordLadder() {
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(new WordLadder().ladderLength("hit", "cog", list));
    }
}
