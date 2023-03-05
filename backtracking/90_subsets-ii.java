/* https://leetcode.com/problems/subsets-ii/ */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        int[] uniqueNums = new int[freq.size()];
        int[] maxs = new int[freq.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> num : freq.entrySet()) {
            uniqueNums[i] = num.getKey();
            maxs[i] = num.getValue();
            i++;
        }
        backtrack(uniqueNums, new int[uniqueNums.length], maxs, 0);
        return result;
    }
    public void backtrack(int[] nums, int[] freq, int[] maxs, int k) {
        result.add(freqToList(nums, freq));
        for (int i = k; i < nums.length; i++) {
            for (int j = 0; j < maxs[i]; j++) {
                freq[i]++;
                backtrack(nums, freq, maxs, i + 1);
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