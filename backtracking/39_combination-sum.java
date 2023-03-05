/* https://leetcode.com/problems/combination-sum/ */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        backtrack(candidates, new int[candidates.length], target, 0);
        return result;
    }
    public void backtrack(int[] candidates, int[] freq, int target, int k) {
        int s = sum(candidates, freq);
        if (s > target)
            return;
        else if (s == target) {
            result.add(freqToList(candidates, freq));
            return;
        }
        else {
            for (int i = k; i < candidates.length; i++) {
                freq[i]++;
                backtrack(candidates, freq, target, i);
                freq[i]--;
            }
        }
    }
    public int sum(int[] candidates, int[] freq) {
        int s = 0;
        for (int i = 0; i < candidates.length; i++)
            s += freq[i] * candidates[i];
        return s;
    }
    public List<Integer> freqToList(int[] candidates, int[] freq) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j < freq[i]; j++)
                l.add(candidates[i]);
        }
        return l;
    }
}