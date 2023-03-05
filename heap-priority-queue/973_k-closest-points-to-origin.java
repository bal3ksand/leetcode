/* https://leetcode.com/problems/k-closest-points-to-origin/ */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1]
                                                                       - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++)
            result[i] = maxHeap.poll();
        return result;
    }
}