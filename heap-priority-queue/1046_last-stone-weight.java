/* https://leetcode.com/problems/last-stone-weight/ */

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones)
            maxHeap.add(stone);
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y > x)
                maxHeap.add(y - x);
        }
        if (maxHeap.size() > 0)
            return maxHeap.poll();
        else
            return 0;
    }
}