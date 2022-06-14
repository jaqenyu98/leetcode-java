package binarySearch;

public class SearchSortedUnknownSizeArray {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        // 两倍向右扩展，复杂度也是logn
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static class ArrayReader {
        public int get(int index) {
            return 0;
        }
    }
}
