/* https://leetcode.com/problems/kth-largest-element-in-an-array/ */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        Random rand = new Random();
        while (left <= right) {
            int p = rand.nextInt(right - left + 1) + left;
            int pivot = nums[p];
            swap(nums, p, right);
            p = left;
            for (int i = left; i <= right; i++) {
                if (nums[i] <= pivot)
                    swap(nums, i, p++);
            }
            p--;
            if (p == nums.length - k)
                return pivot;
            else if (p > nums.length - k)
                right = p - 1;
            else
                left = p + 1;
        }
        return 0;
    }
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}