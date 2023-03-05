/* https://leetcode.com/problems/kth-largest-element-in-a-stream/ */

class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<Integer>();
        this.k = k;
        for (int num : nums)
            this.add(num);
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k)
            minHeap.poll();
        return minHeap.peek();
    }
    
}