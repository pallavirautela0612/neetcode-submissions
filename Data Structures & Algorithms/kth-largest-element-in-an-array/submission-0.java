class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new 
                                PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {

            maxHeap.add(num);
        }

        int count = 0;
        while (count < k-1) {

            maxHeap.poll();
            count++;
        }
        return maxHeap.peek();
    }
}