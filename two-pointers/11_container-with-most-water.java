class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int smallerHeight = Math.min(height[l], height[r]);
            result = Math.max(result, smallerHeight * (r - l));
            while (l < r && height[l] <= smallerHeight)
                l++;
            while (r > l && height[r] <= smallerHeight)
                r--;
        }
        return result;
    }
}