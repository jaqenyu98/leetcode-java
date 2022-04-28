import org.junit.jupiter.api.Test;
import sort.*;

public class MyTest {

    @Test
    public void testBubbleSort() {
        int[] nums = {6,4,1,5,4,5,6,7,8,2,3,1,0,-1};
        BubbleSort.bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
    @Test
    public void testSelectSort() {
        int[] nums = {6,4,1,5,4,5,6,7,8,2,3,1,0,-1};
        SelectSort.selectSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
    @Test
    public void testInsertionSort() {
        int[] nums = {6,4,1,5,4,5,6,7,8,2,3,1,0,-1};
        InsertionSort.insertionSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
    @Test
    public void testMergeSort() {
        int[] nums = {8,2,5,0,7,4,6,1};
        MergeSort.mergeSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
    @Test
    public void testQuickSort(){
        int[] nums = {8,2,5,0,7,4,6,1,1,1,1};
        QuickSort.lomutoQuickSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
    @Test
    public void testHeapSort(){
        int[] nums = {8,2,5,0,7,4,6,1,1,1,1};
        HeapSort.heapSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
