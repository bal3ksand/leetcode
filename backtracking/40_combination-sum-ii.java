/* https://leetcode.com/problems/combination-sum-ii/ */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : candidates)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        int[] nums = new int[freq.size()];
        int[] maxs = new int[freq.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            nums[i] = entry.getKey();
            maxs[i] = entry.getValue();
            i++;
        }
        backtrack(nums, new int[nums.length], maxs, 0, 0, target);
        return result;
    }
    public void backtrack(int[] nums, int[] freq, int[] maxs, int k, int sum, int target) {
        if (sum == target)
            result.add(freqToList(nums, freq));
        else if (sum > target)
            return;
        for (int i = k; i < nums.length; i++) {
            for (int j = 0; j < maxs[i]; j++) {
                freq[i]++;
                backtrack(nums, freq, maxs, i + 1, sum + nums[i] * freq[i], target);
            }
            freq[i] = 0;
        }
    }
    public List<Integer> freqToList(int[] nums, int[] freq) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < freq[i]; j++)
                l.add(nums[i]);
        }
        return l;
    }
}