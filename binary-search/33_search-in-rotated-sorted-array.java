/* https://leetcode.com/problems/search-in-rotated-sorted-array/ */

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 1;
        int r = n - 1;
        int k = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m - 1]) {
                k = m;
                break;
            }
            else if (nums[r] < nums[m])
                l = m + 1;
            else
                r = m - 1;
        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int mk = (m + k) % n;
            if (nums[mk] == target)
                return mk;
            else if (nums[mk] > target)
                r = m - 1;
            else if (nums[mk] < target)
                l = m + 1;
        }
        return -1;
    }
}