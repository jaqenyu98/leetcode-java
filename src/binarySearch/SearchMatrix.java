package binarySearch;

public class SearchMatrix {
    /*--------------------------------------------两次二分-------------------------------------------*/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m;
        int row = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] < target) {
                row = mid;
                l = mid + 1;
            } else if (matrix[mid][0] > target) {
                r = mid;
            } else {
                return true;
            }
        }
        l = 0;
        r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
    /*--------------------------------------------二维数组视作一维-------------------------------------------*/
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 将二维数组视作一维数组，很棒的技巧
            int midVal = matrix[mid / n][mid % n];
            if (midVal < target) {
                l = mid + 1;
            } else if (midVal > target) {
                r = mid;
            } else {
                return true;
            }
        }
        return false;
    }
}
