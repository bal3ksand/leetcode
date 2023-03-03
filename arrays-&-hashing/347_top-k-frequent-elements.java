class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        List<List<Integer>> sorted = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            List<Integer> entry = new ArrayList<Integer>();
            entry.add(e.getKey());
            entry.add(e.getValue());
            sorted.add(entry);
        }
        sorted.sort((a, b) -> Integer.compare(a.get(1), b.get(1)));
        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = sorted.get(sorted.size() - 1 - i).get(0);
        return result;
    }
}