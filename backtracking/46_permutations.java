/* https://leetcode.com/problems/permutations/ */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        p(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }
    public void p(int[] nums, boolean[] k, List<Integer> candidate) {
        if (candidate.size() == nums.length) {
            result.add(new ArrayList<>(candidate));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (k[i])
                continue;
            candidate.add(nums[i]);
            k[i] = true;
            p(nums, k, candidate);
            k[i] = false;
            candidate.remove(candidate.size() - 1);
        }
    }
}