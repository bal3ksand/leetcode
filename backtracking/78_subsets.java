/* https://leetcode.com/problems/subsets/ */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], 0);
        return result;
    }
    public void backtrack(int[] nums, boolean[] freq, int k) {
        result.add(freqToCombo(nums, freq));
        for (int i = k; i < freq.length; i++) {
            freq[i] = true;
            backtrack(nums, freq, i + 1);
            freq[i] = false;
        }
    }
    public List<Integer> freqToCombo(int[] nums, boolean[] freq) {
        List<Integer> combo = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq[i])
                combo.add(nums[i]);
        }
        return combo;
    }
}