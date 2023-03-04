/* https://leetcode.com/problems/search-a-2d-matrix/ */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int a = 0, b = m - 1;
        int row = -1;
        while (a <= b && row == -1) {
            int mid = a + (b - a) / 2;
            if (matrix[mid][0] > target)
                b = mid - 1;
            else if (matrix[mid][n - 1] < target)
                a = mid + 1;
            else
                row = mid;
        }
        if (row == -1)
            return false;

        a = 0; b = n - 1;
        while (a <= b) {
            int mid = a + (b - a) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target)
                b = mid - 1;
            else
                a = mid + 1;
        }
        return false;
    }
}