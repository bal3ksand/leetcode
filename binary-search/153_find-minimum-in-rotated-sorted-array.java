/* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ */

class Solution {
    public int findMin(int[] nums) {
        int l = 1;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m - 1])
                return nums[m];
            else if (nums[r] < nums[m])
                l = m + 1;
            else
                r = m - 1;
        }
        return nums[0];
    }
}