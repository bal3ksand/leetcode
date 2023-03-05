/* https://leetcode.com/problems/task-scheduler/ */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++)
            freqMap.put(tasks[i], freqMap.getOrDefault(tasks[i], 0) + 1);
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.addAll(freqMap.values());

        int time = 0;
        while (!heap.isEmpty()) {
            int k = n + 1;
            List<Integer> used = new ArrayList<>(k);
            while (k > 0 && !heap.isEmpty()) {
                int freq = heap.poll();
                used.add(--freq);
                k--;
                time++;
            }
            for (int freq : used) {
                if (freq > 0)
                    heap.add(freq);
            }
            if (heap.isEmpty())
                break;
            time += k;
        }
        return time;
    }
}